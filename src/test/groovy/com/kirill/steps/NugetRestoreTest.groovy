package com.kirill.steps

class NugetRestoreTest extends GroovyTestCase {

    ResourceBundle loadedProps = ResourceBundle.getBundle('gradle_proj')

    void testCheckProperties() {
        def nugetEx = new NugetRestore(loadedProps)
        assert nugetEx.nugetPathToExe
        assert nugetEx.nugetPatternForSolutionFile
    }
}
