package com.kirill.base

import groovy.transform.TypeChecked

@TypeChecked
class ExecHelper {

    void runCommand(List<String> commandList, String workDir = '.', Boolean failOnError = true) {
        def commListNoSpaces = commandList.collect { it.contains(' ') ? '"' + it + '"' : it }
        commListNoSpaces.each { print it + ' ' }
        println()
        Process proc = getProcess(commListNoSpaces, workDir)
        StreamPrinter outPrint = new StreamPrinter(proc.inputStream, new PrintStream(System.out))
        outPrint.start()
        proc.waitFor()
        if (proc.exitValue()) {
            println "[ERROR] ${proc.err}"
        }
        try {
            assert !proc.exitValue()
        } catch (AssertionError e) {
            println e.message
            if (failOnError) { throw new AssertionError(e.message) }
        }
    }

    private Process getProcess(List<String> commands, String workDir) {
        def pb = new ProcessBuilder(commands)
        pb.redirectErrorStream(true)
                .directory(new File(workDir))
        Process proc = pb.start()
        return proc
    }
}

