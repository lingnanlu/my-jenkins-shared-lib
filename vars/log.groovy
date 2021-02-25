def call(def params, def env) {
    println "${'-' * 20}pipeline begin${'-' * 20}"
    println "branch is ${params.BRANCH}"
    println "env is ${params.ENV}"
    println "server is ${params.SERVER}"
}
