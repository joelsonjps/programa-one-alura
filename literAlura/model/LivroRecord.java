package com.alura.literalura.model;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroRecord(
                @JsonAlias("id") Integer id,
                @JsonAlias("title") String titulo,
                @JsonAlias("author") String autor,
                @JsonAlias("language") String idioma,
                @JsonAlias("subjects") List<String>categoria,
                @JsonAlias("downloads") int downloads,
                @JsonAlias("formats") Map<String, String> formats) {
}
