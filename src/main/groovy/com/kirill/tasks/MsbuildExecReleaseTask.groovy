package com.kirill.tasks

import com.kirill.base.CustomTask
import com.kirill.steps.DotNetBuild
import groovy.transform.InheritConstructors
import org.gradle.api.tasks.TaskAction

@InheritConstructors
class MsbuildExecReleaseTask extends CustomTask {
    @TaskAction
    runBuild() {
        def msbuild = new DotNetBuild('minimal', 'Release', 'Any CPU', loadedProps)
        msbuild.makeBuild(loadedProps.getString('msbuild.PatternForSolutionFile'))
    }
}
