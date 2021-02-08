
def call(String distDir, List<String> files, List<String> run, String server) {
    println "${'-' * 20}deploy begin${'-' * 20}"

    println(distDir)
    println(files)
    println(run)
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
}
