def call(def workDir, def cmd) {
    println "build begin"
    println "workdir is ${workDir}"
    println "cmd is ${cmd}"

    for (i in 0..<cmd.length) {
        sh cmd[i]
    }
}