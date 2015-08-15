package com.digitalreasoning.nlptest.domain

import com.digitalreasoning.nlptest.enums.NLPConstants

class Sentence {
    int id
    def regex
    def content

    Sentence() {
        regex = "(?<=\\${NLPConstants.questionMark})|" +
                "(?<=\\${NLPConstants.period})" +
                "(?!\\${NLPConstants.period}${NLPConstants.period})" +
                "(?!\\${NLPConstants.doubleQuotes})" +
                "(?!${NLPConstants.spaceFollowedByLowerCase})"
    }

}
