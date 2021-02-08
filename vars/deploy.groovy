
def call(String distDir, List<String> files, List<String> run, String server) {
    println "${'-' * 20}deploy begin${'-' * 20}"

    println(distDir)
    println(files)
    println(run)
    println(server)




//    def transferClourse =

//    sshPublisher(
//            publishers: [
//                    sshPublisherDesc(
//                            configName: "${server}",
//                            transfers: [
//                                    sshTransfer(cleanRemote: false, sourceFiles: files[0], remoteDirectory: distDir),
//                                    sshTransfer(cleanRemote: false, sourceFiles: files[1], remoteDirectory: distDir)
//                            ]
//                    )
//            ]
//    )

    def file = "deploy/*"
    println "files[1] == ${files[1]}"
    sshPublisher(
            publishers: [
                    sshPublisherDesc(
                            configName: "${server}",
                            transfers: [
                                    sshTransfer(cleanRemote: false, sourceFiles: 'target/*.jar', removePrefix: 'target', remoteDirectory: distDir),
                                    sshTransfer(cleanRemote: false, sourceFiles: file, remoteDirectory: distDir)
                            ]
                    )
            ]
    )
}
