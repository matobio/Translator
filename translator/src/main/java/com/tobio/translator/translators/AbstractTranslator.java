package com.tobio.translator.translators;

import com.tobio.translator.interfaces.ICustomTranslator;
import com.tobio.translator.utils.Constants;

public abstract class AbstractTranslator {

    public static ICustomTranslator getTranslator(String translatorKey) {

        switch (translatorKey) {

            case Constants.KEY_GOOGLE_API_TRANSLATOR:
                return GoogleTranslator.getInstance();

            default:
                return GoogleTranslator.getInstance();

        }
    }
}
