package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.transform.TypeChecked

@TypeChecked
class ZipRunner {
    String pathToExe

    ZipRunner(String pathToExe) {
        this.pathToExe = pathToExe
    }

    def runZip(List<String> fileList, String resultsFile, String srcFolder) {
        ArrayList<String> commandList = []
        commandList.add(pathToExe)
        commandList.add('a')
        commandList.add(resultsFile)
        commandList.addAll(fileList)
        def execHelper = new ExecHelper()
        execHelper.runCommand(commandList, srcFolder, true)
    }
}
