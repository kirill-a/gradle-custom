package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.mock.interceptor.MockFor

class NugetRunnerTest extends GroovyTestCase {
    void testRestoreDependenciesWithNuget() {
        def mock = new MockFor(ExecHelper)
        mock.demand.runCommand{ 'hello' }
        mock.use {
            def nugetRunner = new NugetRunner('')
            assert nugetRunner.runNuget('') == 'hello'
        }
    }
}
