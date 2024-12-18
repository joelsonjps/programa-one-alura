package com.alura.literalura.service;

import com.alura.literalura.model.Livro;
import com.alura.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.IntSummaryStatistics;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro buscarLivroPorTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo);
    }

    public List<Livro> listarTodosOsLivros() {
        return livroRepository.findAll();
    }

    public List<Livro> listarLivrosPorIdioma(String idioma) {
        return livroRepository.findByIdioma(idioma);
    }

    public IntSummaryStatistics calcularEstatisticasPorIdioma(String idioma) {
        List<Livro> livros = listarLivrosPorIdioma(idioma);
        return livros.stream()
                .mapToInt(Livro::getDownloads)
                .summaryStatistics();
    }

    public List<Livro> listarTop10LivrosMaisBaixados() {
        return livroRepository.findTop10ByOrderByDownloadsDesc();
    }
}
