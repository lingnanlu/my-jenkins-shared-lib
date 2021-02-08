def call(def params, def env) {
    println "pipeline begin"
    println "branch is ${params.BRANCH}"
    println "env is ${params.ENV}"
    println "server is ${params.SERVER}"
}
