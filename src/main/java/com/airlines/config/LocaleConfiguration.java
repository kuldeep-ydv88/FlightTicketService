package com.airlines.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;
/**
 * @author Kuldeep
 * Initialize Locale Resolver
 */
@Configuration
public class LocaleConfiguration {
    private static String BASE_NAME = "message";
    private static String DEFAULT_ENCODING = "UTF-8";

    @Bean(name = "customMessageSource")
    public MessageSource messageSource () {
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource ();
        bundleMessageSource.setBasename(BASE_NAME);
        bundleMessageSource.setDefaultEncoding(DEFAULT_ENCODING);
        bundleMessageSource.setUseCodeAsDefaultMessage(true);
        return bundleMessageSource;
    }

    @Bean
    public LocaleResolver localeResolver () {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);
        return acceptHeaderLocaleResolver;
    }

}
