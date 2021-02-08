def call(def distDir, def files, def run) {

    println(distDir)
    println(files)
    println(run)

    def transfer = new ArrayList()

    for (int i; i < files.size(); i++) {

        transfer.add( sshTransfer(cleanRemote: false, sourceFiles: files[i], remoteDirectory: distDir))

    }

    sshPublisher(
            publishers: [
                    sshPublisherDesc(
                            configName: "${SERVER}",
                            transfers: transfer
                    )
            ]
    )
}
