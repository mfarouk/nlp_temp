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
        //def inputData = input.readInputFile("${conf.inputConfig.input.files.path}/${file}")
        //def paragraphs = paragraph.splitIntoParagraphs(inputData)
        //def sentences = sentence.splitIntoSentences(paragraphs)
        //def word = word.splitIntoWords(sentences)
        //def xml = new groovy.xml.MarkupBuilder()
        /*xml.input(type:"text"){
            Paragrahs(){
                Sentences(){
                    words(){

                    }
                }
            }

        }*/


    }

}
