package com.alura.literalura.controller;

import com.alura.literalura.model.Livro;
import com.alura.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroController {

    @Autowired
    private LivroService livroService;

    public Livro buscarLivroPorTitulo(String titulo) {
        return livroService.buscarLivroPorTitulo(titulo);
    }

    public List<Livro> listarTodosOsLivros() {
        return livroService.listarTodosOsLivros();
    }

    public List<Livro> listarLivrosPorIdioma(String idioma) {
        return livroService.listarLivrosPorIdioma(idioma);
    }

    public DoubleSummaryStatistics calcularEstatisticasPorIdioma(String idioma) {
        return livroService.calcularEstatisticasPorIdioma(idioma);
    }

    public List<Livro> listarTop10LivrosMaisBaixados() {
        return livroService.listarTop10LivrosMaisBaixados();
    }
}
