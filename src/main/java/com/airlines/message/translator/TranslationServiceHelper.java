package com.airlines.message.translator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * This service will translate the message as per locale passed in the Request Header
 *
 */
@Component
public class TranslationServiceHelper {
    @Qualifier(value = "customMessageSource")
    @Autowired
    private MessageSource messageSource;


    /**
     * Return the value of the property as per the locale passed in request header
     * @param key
     * @return
     */
    public String getTranslation (String key) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, null, locale);
    }

    /**
     * Return the value of the property as per the locale passed in request header and also substitutes the value of arguments
     * @param key
     * @param args
     * @return
     */
    public String getTranslation (String key, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(key, args ,null, locale);
    }
}
