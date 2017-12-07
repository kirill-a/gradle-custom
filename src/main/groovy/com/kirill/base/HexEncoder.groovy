package com.kirill.base

import groovy.transform.TypeChecked

@TypeChecked
class HexEncoder {

    String getEncodedFileContents(String filePath) {
        File f = new File(filePath)
        String encoded = f.bytes.encodeHex()
        return encoded
    }
}
