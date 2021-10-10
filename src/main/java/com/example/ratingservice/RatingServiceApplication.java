package com.example.ratingservice;

import io.sentry.GsonSerializer;
import io.sentry.ITransportFactory;
import io.sentry.SentryOptions;
import io.sentry.transport.StdoutTransport;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@SpringBootApplication
public class RatingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingServiceApplication.class, args);
    }

    @Bean
    Jackson2JsonMessageConverter mappingJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

