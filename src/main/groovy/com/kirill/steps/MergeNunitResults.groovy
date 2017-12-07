package com.kirill.steps

import com.kirill.base.XmlMerger
import groovy.transform.TypeChecked

@TypeChecked
class MergeNunitResults {

    final String resultsDir

    MergeNunitResults(ResourceBundle props) {
        resultsDir = props.getString("aat.resultsDir")
    }

    def mergeNunitResults() {
        def xmlMerge = new XmlMerger()
        xmlMerge.mergeXml(resultsDir, "*.xml", 'test-results', 'test-suite', resultsDir + 'nunit_results.xml')
    }
}
