package com.kirill.steps

import com.kirill.base.runners.MsbuildRunner
import groovy.transform.TypeChecked

@TypeChecked
class DotNetBuild {

    final String msbuildVerbosityLevel, msbuildBuildConfiguration, msbuildBuildPlatform, pathToExe

    DotNetBuild(String verbosityLevel, String buildConfiguration, String buildPlatform, ResourceBundle props) {
        msbuildVerbosityLevel = verbosityLevel
        msbuildBuildConfiguration = buildConfiguration
        msbuildBuildPlatform = buildPlatform
        pathToExe = props.getString('msbuild.PathToExe')
    }

    DotNetBuild(String verbosityLevel, ResourceBundle props) {
        msbuildVerbosityLevel = verbosityLevel
        msbuildBuildConfiguration = null
        msbuildBuildPlatform = null
        pathToExe = props.getString('msbuild.PathToExe')
    }

    def makeBuild(String patternForSolutionFile) {
        def msbuild = new MsbuildRunner(
                pathToExe,
                msbuildVerbosityLevel,
                msbuildBuildConfiguration,
                msbuildBuildPlatform
        )
        List<String> solutionFiles = new FileNameFinder().getFileNames('.', patternForSolutionFile)
        for (s in solutionFiles) {
            println "--------Starting build for: " + s
            println "--------Now building--------"
            msbuild.runMsbuild(s)
            println "\n--------Build completed--------"
        }
    }
}
