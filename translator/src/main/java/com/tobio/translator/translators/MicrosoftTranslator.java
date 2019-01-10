package com.tobio.translator.translators;

import com.tobio.translator.interfaces.ICustomTranslator;

public class MicrosoftTranslator implements ICustomTranslator {

    protected static MicrosoftTranslator instance;

    private static final String          API_KEY = "YOUR_SUBSCRIPTION_KEY";
    private static final String          URL     = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=de,it";


    protected MicrosoftTranslator() {}


    public static MicrosoftTranslator getInstance() {
        if (MicrosoftTranslator.instance == null) {
            MicrosoftTranslator.instance = new MicrosoftTranslator();
        }
        return MicrosoftTranslator.instance;
    }


    @Override
    public String translate(String langFrom, String langTo, String textToTranslate) {
        // TODO Auto-generated method stub
        return null;
    }

}
