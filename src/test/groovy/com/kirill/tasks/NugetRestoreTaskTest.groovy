package com.kirill.tasks

import com.kirill.steps.NugetRestore
import groovy.mock.interceptor.MockFor
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

class NugetRestoreTaskTest extends GroovyTestCase {
    void testRunNuget() {
        def mock = new MockFor(NugetRestore)
        mock.demand.runNuget(1) { }
        mock.use {
            Project project = ProjectBuilder.builder().build()
            def task = project.task('test', type: NugetRestoreTask)
            assertTrue(task instanceof NugetRestoreTask)
            task.execute()
        }
    }
}
