package com.kirill.base

import org.apache.commons.codec.digest.DigestUtils

class MD5Calculator {

    static String calculateHash(String dir) {
        println('--------Generating hash for ' + dir)
        String content = ''
        new File(dir).eachFileRecurse { file ->
            if (file.isFile()) {
                content += (file.text)
            }
        }
        return DigestUtils.md5Hex(content)
    }
}
