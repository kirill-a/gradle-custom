package com.kirill.tasks

import com.kirill.steps.DotNetBuild
import groovy.mock.interceptor.MockFor
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

class MsbuildExecReleaseTaskTest extends GroovyTestCase {
    void testRunBuild() {
        def mock = new MockFor(DotNetBuild)
        mock.demand.makeBuild(1) { }
        mock.use {
            Project project = ProjectBuilder.builder().build()
            def task = project.task('test', type: MsbuildExecReleaseTask)
            assertTrue(task instanceof MsbuildExecReleaseTask)
            task.execute()
        }
    }
}
