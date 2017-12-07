package com.kirill.base.tasks

import com.kirill.steps.CheckCodepage
import groovy.mock.interceptor.MockFor
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import groovy.util.GroovyTestCase

class CheckCodepageTaskCommonTest extends GroovyTestCase {
    void testCheck() throws Exception {
        def mock = new MockFor(CheckCodepage)
        mock.demand.checkAllFiles(1) {  }
        mock.use {
            Project project = ProjectBuilder.builder().build()
            def task = project.task('test', type:CheckCodepageTaskCommon)
            assertTrue(task instanceof CheckCodepageTaskCommon)
            task.execute()
        }
    }
}
