package com.alura.literalura.principal;

import com.alura.literalura.model.Livro;
import com.alura.literalura.model.LivroConversor;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Principal {
    public static void main(String[] args) {

        LivroConversor conversor = new LivroConversor();

        try {
            Livro livro = conversor.fromJson(jsonString);

            System.out.println("Título do Livro: " + livro.getTitulo());
            System.out.println("Autor do Livro: " + livro.getAutor());
            System.out.println("Idioma do Livro: " + livro.getIdioma());
            System.out.println("Downloads: " + livro.getDownloads());
            System.out.println("Temas do Livro: " + String.join(", ", livro.getTemas()));
            System.out.println("Formatos disponíveis:");
            livro.getFormatos().forEach((format, url) -> {
                System.out.println(format + ": " + url);
            });

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
