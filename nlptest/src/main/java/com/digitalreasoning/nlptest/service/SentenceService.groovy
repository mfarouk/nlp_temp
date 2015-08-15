package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.domain.Paragraph
import com.digitalreasoning.nlptest.domain.Sentence

@Singleton
class SentenceService {

    def splitIntoSentences(paragraphs){
        Sentence sentence = new Sentence()
        def sentenceList = [:]
        int offset = 1
        paragraphs.eachWithIndex{ paragraph,index ->
            Paragraph paragraph1 = new Paragraph()
            paragraph1.id = index + offset
            def sentences = paragraph.split(sentence.regex)
            def sentencesWithoutBlanks = sentences.findAll{item->!item.isEmpty()}
            sentencesWithoutBlanks.each{item ->
                sentenceList.put(paragraph1,item.trim())
            }
        }
        return sentenceList
    }
}
