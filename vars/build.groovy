def call(String workDir, List<String> cmd) {
    println "${'-' * 20}build begin${'-' * 20}"
    println "workdir is ${workDir}"
    println "cmd is ${cmd}"

    cd workDir

    for (int i = 0; i < cmd.size(); i++) {
        println cmd[i]
        sh cmd[i]
    }
}