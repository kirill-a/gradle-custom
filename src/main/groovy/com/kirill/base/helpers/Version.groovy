package com.kirill.base.helpers

import groovy.transform.CompileStatic

@CompileStatic
class Version implements Comparable {
    private final int major
    private final int minor
    private final int micro
    private final String qualifier
    private static final String SEPARATOR = "."

    public static final Version EMPTY = new Version(0, 0, 0)

    Version(int major, int minor, int micro) {
        this(major, minor, micro, null)
    }

    Version(int major, int minor, int micro, String qualifier) {
        if (qualifier == null) {
            qualifier = ""
        }
        this.major = major
        this.minor = minor
        this.micro = micro
        this.qualifier = qualifier
        validate()
    }

    Version(String version) {
        int major = 0
        int minor = 0
        int micro = 0
        String qualifier = ""

        try {
            StringTokenizer st = new StringTokenizer(version, SEPARATOR, true)
            major = Integer.parseInt(st.nextToken())

            if (st.hasMoreTokens()) {
                st.nextToken()
                minor = Integer.parseInt(st.nextToken())

                if (st.hasMoreTokens()) {
                    st.nextToken()
                    micro = Integer.parseInt(st.nextToken())

                    if (st.hasMoreTokens()) {
                        st.nextToken()
                        qualifier = st.nextToken()

                        if (st.hasMoreTokens()) {
                            throw new IllegalArgumentException("invalid format")
                        }
                    }
                }
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid format")
        }

        this.major = major
        this.minor = minor
        this.micro = micro
        this.qualifier = qualifier
        validate()
    }

    private void validate() {
        if (major < 0) {
            throw new IllegalArgumentException("negative major")
        }
        if (minor < 0) {
            throw new IllegalArgumentException("negative minor")
        }
        if (micro < 0) {
            throw new IllegalArgumentException("negative micro")
        }
    }

    static Version parseVersion(String version) {
        if (version == null) {
            return EMPTY
        }

        String trimmedVersion = version.trim()
        if (trimmedVersion.length() == 0) {
            return EMPTY
        }

        return new Version(trimmedVersion)
    }

    int getMajor() {
        return major
    }

    int getMinor() {
        return minor
    }

    int getMicro() {
        return micro
    }

    String getQualifier() {
        return qualifier
    }

    String toString() {
        String base = major + SEPARATOR + minor + SEPARATOR + micro
        if (qualifier.length() == 0) {
            return base
        }
        return base + SEPARATOR + qualifier
    }

    int hashCode() {
        return (major << 24) + (minor << 16) + (micro << 8) + qualifier.hashCode()
    }

    boolean equals(Object object) {
        if (object == this) {
            return true
        }

        if (!(object instanceof Version)) {
            return false
        }

        Version other = (Version) object
        return (major == other.major) && (minor == other.minor) && (micro == other.micro) &&
                qualifier == other.qualifier
    }

    int compareTo(Object object) {

        Version other = (Version) object

        int result = major - other.major
        if (result != 0) {
            return result
        }

        result = minor - other.minor
        if (result != 0) {
            return result
        }

        result = micro - other.micro
        if (result != 0) {
            return result
        }

        return qualifier <=> other.qualifier
    }
}
