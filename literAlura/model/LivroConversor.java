package com.alura.literalura.model;

import com.alura.literalura.model.Livro;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LivroConversor {

    private ObjectMapper objectMapper;

        public LivroConversor() {
            this.objectMapper = new ObjectMapper();
        }

        public Livro fromJson(String jsonString) throws JsonProcessingException {
            return objectMapper.readValue(jsonString, Livro.class);
        }
    }


