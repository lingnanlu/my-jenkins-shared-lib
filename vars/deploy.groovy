
def call(String distDir, List<String> files, List<String> run, String server) {
    println "${'-' * 20}deploy begin${'-' * 20}"

    println(distDir)
    println(files)
    println(run)
    println(server)

//    def transfer = new ArrayList()
//
//    for (int i = 0; i < files.size(); i++) {
//        transfer.add(sshTransfer(cleanRemote: false, sourceFiles: files[i], remoteDirectory: distDir))
//    }
//
//    sshPublisher(
//            publishers: [
//                    sshPublisherDesc(
//                            configName: "${server}",
//                            transfers: transfer
//                    )
//            ]
//    )

    sshPublisher(
            publishers: [
                    sshPublisherDesc(
                            configName: "${server}",
                            transfers: [
                                    sshTransfer(cleanRemote: false, sourceFiles: 'target/*.jar', removePrefix: 'target', remoteDirectory: distDir),
                                    sshTransfer(cleanRemote: false, sourceFiles: 'deploy/*', remoteDirectory: distDir)
                            ]
                    )
            ]
    )
}
