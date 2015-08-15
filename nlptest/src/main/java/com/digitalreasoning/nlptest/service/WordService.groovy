package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.domain.Word
@Singleton
class WordService {

    def splitIntoWords(sentences) {
        Word word = new Word()
        def words = []
        sentences.each { sentence ->
            sentence.split(word.regex).each { item ->
                words.add(item)
            }
        }
        def wordWithoutBlanks = words.findAll{item->!item.isEmpty()}
        return wordWithoutBlanks
    }
}
