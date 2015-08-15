package com.digitalreasoning.nlptest

import com.digitalreasoning.nlptest.config.ConfigManager
import com.digitalreasoning.nlptest.logging.ErrorLogger
import com.digitalreasoning.nlptest.service.Tokenizer



class App
{
    static Tokenizer tokenizer = Tokenizer.instance
    static ConfigManager conf = ConfigManager.getInstance()

    static void main( String[] args )
    {
        Tokenizer.tokenize("${conf.inputConfig.input.files.nlp.data}")
        ErrorLogger.log.info "GoodBye!"

    }
}
