def call(String yamlName) {

    log(params, env)

    def yaml = readYaml file: yamlName;

    // 如果build存在
    if (yaml.build) {
        def buildConf = yaml.build
        build(buildConf.workDir, buildConf.cmd)
    }

    if (yaml.deploy) {
        def deployConf = yaml.deploy
        deploy(deployConf.distDir, deployConf.files, deployConf.run, params.SERVER)
    }

    clean()
}