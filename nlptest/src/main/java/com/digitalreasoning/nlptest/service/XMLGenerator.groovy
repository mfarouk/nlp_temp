package com.digitalreasoning.nlptest.service

import com.digitalreasoning.nlptest.config.ConfigManager
import groovy.xml.MarkupBuilder


class XMLGenerator {
    static SentenceService sentence = SentenceService.instance
    static ParagraphService paragraph = ParagraphService.instance
    static WordService word =  WordService.instance
    static InputReader input = InputReader.instance
    static ConfigManager conf = ConfigManager.getInstance()

    def generateXML(file){
        def inputData = input.readInputFile("${conf.inputConfig.input.files.path}/${file}")
        def paragraphs = paragraph.splitIntoParagraphs(inputData)
        def sentences = sentence.splitIntoSentences(paragraphs)
        def words = word.splitIntoWords(sentences)
        def xml = new groovy.xml.MarkupBuilder()
        xml.input(type:"text"){
            Paragrahs(){
                paragraphs.eachWithIndex {par,index->
                    Paragraph(id:"${index+1}",par){
                        Sentences(){
                            sentences.eachWithIndex{sentence,paragraph_num,index2 ->
                                if (index+1 == paragraph_num){
                                    Sentence(sentence){
                                        Words(){
                                            words.each{key,word ->
                                                if(key.split("|")[2] as int == paragraph_num as int &&
                                                        key.split("|")[0] as int == index2+1){
                                                    Word(word)
                                                }
                                            }

                                        }

                                    }
                                }

                            }
                        }

                    }
                }

            }


        }



    }

}
