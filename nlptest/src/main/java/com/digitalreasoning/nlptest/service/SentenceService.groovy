package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.domain.Sentence

@Singleton
class SentenceService {

    def splitIntoSentences(paragraphs){
        Sentence sentence = new Sentence()
        def sentenceList = [index:"",value:""]
        int offset = 1
        paragraphs.eachWithIndex{ paragraph,index ->
            def sentences = paragraph.split(sentence.regex)
            def sentencesWithoutBlanks = sentences.findAll{item->!item.isEmpty()}
            sentencesWithoutBlanks.each{item ->
                sentenceList.index.add(index)
                sentenceList.value.add(item.trim())
            }
        }
        return sentenceList
    }
}
