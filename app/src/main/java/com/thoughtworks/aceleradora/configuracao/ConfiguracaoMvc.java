package com.thoughtworks.aceleradora.configuracao;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.format.DateTimeFormatter;

@Configuration
public class ConfiguracaoMvc implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar formatoBrasileiro = new DateTimeFormatterRegistrar();
        formatoBrasileiro.setDateFormatter(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        formatoBrasileiro.registerFormatters(registry);
    }
}
