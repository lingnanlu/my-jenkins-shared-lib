def call(def workDir, def cmd) {
    println "${'-' * 20}build begin${'-' * 20}"
    println "workdir is ${workDir}"
    println "cmd is ${cmd}"

    for (i in 0..<cmd.length) {
        println cmd[i]
        sh cmd[i]
    }
}