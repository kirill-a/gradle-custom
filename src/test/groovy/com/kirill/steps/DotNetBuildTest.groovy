package com.kirill.steps

class DotNetBuildTest extends GroovyTestCase {

    ResourceBundle loadedProps = ResourceBundle.getBundle('gradle_proj')

    void testMsbuildWithParameters() {
        def msbuild = new DotNetBuild('a','b','c',loadedProps)
        assert msbuild.pathToExe
        assert msbuild.msbuildVerbosityLevel
        assert msbuild.msbuildBuildConfiguration
        assert msbuild.msbuildBuildPlatform
    }

    void testMsbuildLessParameters() {
        def msbuild = new DotNetBuild('a',loadedProps)
        assert msbuild.pathToExe
        assert msbuild.msbuildVerbosityLevel
        assert !msbuild.msbuildBuildConfiguration
        assert !msbuild.msbuildBuildPlatform
    }
}
