package com.examplekush316.content_calendar.config;

import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.examplekush316.content_calendar.model.Content;
import com.examplekush316.content_calendar.repository.ContentRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

///@Profile("!dev")
@Component
public class DataLoader implements CommandLineRunner {

    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception{
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")){
            repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>(){}));
        }
    }
}
