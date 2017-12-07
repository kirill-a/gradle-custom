package com.kirill.base.runners

import com.kirill.base.ExecHelper
import groovy.mock.interceptor.MockFor

class NunitRunnerTest extends GroovyTestCase {
    void testRunNunit() {
        def mock = new MockFor(ExecHelper)
        mock.demand.runCommand{ commandList, workDir, failOnError -> }
        mock.use {
            def nunit = new NunitRunner('')
            nunit.runNunit('', '')
        }
    }
}
