package com.kirill.steps

import com.kirill.base.runners.NugetRunner
import groovy.transform.TypeChecked

@TypeChecked
class NugetRestore {
    final String nugetPathToExe, nugetPatternForSolutionFile

    NugetRestore(ResourceBundle props) {
        nugetPathToExe = props.getString('nuget.PathToExe')
        nugetPatternForSolutionFile = props.getString('nuget.PatternForSolutionFile')
    }

    def runNuget() {
        def nugetRunner = new NugetRunner(nugetPathToExe)
        List<String> solutionFiles = new FileNameFinder().getFileNames('.', nugetPatternForSolutionFile)
        println "--------Dependencies will now be downloaded--------"
        solutionFiles.each { nugetRunner.runNuget(it) }
        println "\n--------Dependencies have been restored--------"
    }
}
