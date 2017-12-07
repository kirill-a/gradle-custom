package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.transform.TypeChecked

@TypeChecked
class NunitRunner {
    String pathToExe

    NunitRunner(String pathToExe) {
        this.pathToExe = pathToExe
    }

    def runNunit(String testDlls, String resultsFile) {
        ArrayList<String> commandList = []
        commandList.add(pathToExe)
        commandList.add(testDlls)
        commandList.add("/xml=" + resultsFile)
        commandList.add("/framework:net-4.0")
        commandList.add("/noshadow")
        commandList.add("/nologo")
        def execHelper = new ExecHelper()
        execHelper.runCommand(commandList, '.', false)
    }
}
