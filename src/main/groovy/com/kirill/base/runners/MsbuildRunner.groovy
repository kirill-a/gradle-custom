package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.transform.TypeChecked

@TypeChecked
class MsbuildRunner {
    String pathToExe, verbosityLevel, buildConfiguration, buildPlatform

    MsbuildRunner(String pathToExe, String verbosityLevel, String buildConfiguration, String buildPlatform) {
        this.pathToExe = pathToExe
        this.verbosityLevel = verbosityLevel
        this.buildConfiguration = buildConfiguration
        this.buildPlatform = buildPlatform
    }

    def runMsbuild(String projectToBuild) {
        String baseDir = new File(".").canonicalPath
        String PROJ_ROOT = baseDir
        String OUT_DIR = baseDir + '/out'
        List<String> commandList = []
        commandList.add(pathToExe)
        commandList.add(projectToBuild)
        commandList.add("/v:" + verbosityLevel)
        buildConfiguration ? commandList.add("/p:Configuration=" + buildConfiguration) : buildConfiguration
        buildPlatform ? commandList.add("/p:Platform=" + buildPlatform) : buildPlatform
        commandList.add("/p:PROJ_ROOT=" + PROJ_ROOT)
        commandList.add("/p:OUT_DIR=" + OUT_DIR)
        if (System.getenv('VS120COMNTOOLS') != null) {
            commandList.add("/p:VisualStudioVersion=12.0")
        } else if (System.getenv('VS100COMNTOOLS') != null) {
            commandList.add("/p:VisualStudioVersion=10.0")
        }
        def execHelper = new ExecHelper()
        return execHelper.runCommand(commandList)
    }
}
