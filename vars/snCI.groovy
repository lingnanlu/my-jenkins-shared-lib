def call(String yamlName) {

    def yaml = readYaml file: yamlName;

    log()

    // 如果build存在
    if (yaml.build) {
        println(yaml.build)
        def buildConf = yaml.build
        build(buildConf.workDir, buildConf.cmd)
    }

    if (yaml.deploy) {
        def deployConf = yaml.deploy
        deploy(deployConf.distDir, deployConf.files, deployConf.run)
    }

    clean()
}