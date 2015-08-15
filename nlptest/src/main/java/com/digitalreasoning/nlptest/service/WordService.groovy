package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.domain.Sentence
import com.digitalreasoning.nlptest.domain.Word

@Singleton
class WordService {

    def splitIntoWords(sentences) {
        Word word = new Word()
        def sentences_only = []
        def words = []
        def wordsMap = [:]
        int offset = 1
        sentences.each { sentence, paragraph ->
            sentences_only.add(sentence)
        }
        sentences_only.eachWithIndex { sentence, index ->
            Sentence sentence_object = new Sentence()
            sentence_object.id = index + offset
            sentence.split(word.regex).each { item ->
                if (item.findAll{itm->!itm.isEmpty()}){
                    wordsMap.put("Sentence number:${sentence_object.id.toString()}|${java.util.UUID.randomUUID()}",item)
                }

            }
        }
        return wordsMap
    }
}
