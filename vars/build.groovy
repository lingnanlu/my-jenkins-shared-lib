def call(def workDir, def cmd) {
    println(workDir)
    println(cmd[0])
    sh cmd[0]
}