def call(String yamlName) {

    try {
        log(params, env)

        def yaml = readYaml file: yamlName;

        if (yaml.build) {
            def buildConf = yaml.build
            build(buildConf.workDir, buildConf.cmd)
        }

        if (yaml.deploy) {
            def deployConf = yaml.deploy
            deploy(deployConf.distDir, deployConf.files, deployConf.run, params.SERVER)
        }
    } finally {
        clean()
    }

}