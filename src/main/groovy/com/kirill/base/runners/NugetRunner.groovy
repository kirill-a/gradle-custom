package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.transform.TypeChecked

@TypeChecked
class NugetRunner {
    String pathToExe

    NugetRunner(String pathToExe) {
        this.pathToExe = pathToExe
    }

    def runNuget(String pathToSolutionFile) {
        ArrayList<String> commandList = []
        commandList.add(pathToExe)
        commandList.add('restore')
        commandList.add(pathToSolutionFile)
        def execHelper = new ExecHelper()
        return execHelper.runCommand(commandList)
    }
}
