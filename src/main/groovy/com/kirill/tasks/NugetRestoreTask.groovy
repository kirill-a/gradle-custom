package com.kirill.tasks

import com.kirill.base.CustomTask
import com.kirill.steps.NugetRestore
import groovy.transform.InheritConstructors
import org.gradle.api.tasks.TaskAction

@InheritConstructors
class NugetRestoreTask extends CustomTask {
    @TaskAction
    runNuget() {
        def nuget = new NugetRestore(loadedProps)
        nuget.runNuget()
    }
}
