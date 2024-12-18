package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Livro {
    @JsonAlias("id")
    private int id;

    @JsonAlias("title")
    private String titulo;

    @JsonAlias("author")
    private String autor;

    @JsonAlias("language")
    private String idioma;

    @JsonAlias("subjects")
    private List<String> temas;

    @JsonAlias("downloads")
    private int downloads;

    @JsonAlias("formats")
    private Map<String, String> formatos;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public List<String> getTemas() {
        return temas;
    }

    public void setTemas(List<String> temas) {
        this.temas = temas;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public Map<String, String> getFormatos() {
        return formatos;
    }

    public void setFormatos(Map<String, String> formatos) {
        this.formatos = formatos;
    }

    @Override
    public String toString() {
        return "Livro " +
                 id +
                ", titulo = '" + titulo + '\'' +
                ", autor = '" + autor + '\'' +
                ", idioma = '" + idioma + '\'' +
                ", temas = " + temas +
                ", downloads = " + downloads +
                ", formatos = " + formatos;
    }
}