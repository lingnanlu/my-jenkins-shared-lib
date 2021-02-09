
def call(String distDir, List<String> files, List<String> cmds, String server) {
    println "${'-' * 20}deploy begin${'-' * 20}"

    println(distDir)
    println(files)
    println(cmds)
    println(server)

    def transfer = new ArrayList()

    for (String file : files) {
        transfer.add( sshTransfer(cleanRemote: false, sourceFiles: file, remoteDirectory: distDir) )
    }

    sshPublisher(
            publishers: [
                    sshPublisherDesc(
                            configName: "${server}",
                            transfers: transfer
                    )
            ]
    )

    def execCmd = new ArrayList()

    for (String cmd : cmds) {
        execCmd.add(sshTransfer(execCommand: "cd ${distDir} && ${cmd}"))
    }

    sshPublisher(
            publishers: [
                    sshPublisherDesc(
                            configName: "${server}",
                            transfers: execCmd
                    )
            ]
    )
}
