package com.digitalreasoning.nlptest

import com.digitalreasoning.nlptest.config.ConfigManager
import com.digitalreasoning.nlptest.logging.ErrorLogger
import com.digitalreasoning.nlptest.service.Tokenizer
import com.digitalreasoning.nlptest.service.XMLGenerator



class App
{
    static Tokenizer tokenizer = Tokenizer.instance
    static ConfigManager conf = ConfigManager.getInstance()
    static XMLGenerator xmlGen = new XMLGenerator()
    static void main( String[] args )
    {
        Tokenizer.tokenize("${conf.inputConfig.input.files.nlp.data}")
        ErrorLogger.log.info "GoodBye!"
        xmlGen.generateXML("${conf.inputConfig.input.files.nlp.data}")

    }
}
