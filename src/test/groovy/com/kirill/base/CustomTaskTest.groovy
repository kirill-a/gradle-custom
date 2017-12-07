package com.kirill.base

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

class CustomTaskTest extends GroovyTestCase {
    void testSetLoadedProps() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('ctask', type: CustomTask)
        assert (task instanceof CustomTask)
    }
}
