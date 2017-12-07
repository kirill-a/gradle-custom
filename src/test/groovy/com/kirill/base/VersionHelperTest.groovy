package com.kirill.base

class VersionHelperTest extends GroovyTestCase {
    void testMajor() {
        def ver = new VersionHelper()
        ver.createVersionList('3.99.1.0')
        assert ver.major() == '3'
    }

    void testMinor() {
        def ver = new VersionHelper()
        ver.createVersionList('3.99.1.0')
        assert ver.minor() == '99'
    }

    void testRelease() {
        def ver = new VersionHelper()
        ver.createVersionList('3.99.1.0')
        assert ver.release() == '1'
    }

    void testRevision() {
        def ver = new VersionHelper()
        ver.createVersionList('3.99.1.0')
        assert ver.revision() == '0'
    }

    void testGetNewVersion() {
        assert VersionHelper.getNewVersion('1.2.3.4') == '1.2.3.0'
    }
}
