package com.alura.literalura.controller;

import com.alura.literalura.model.Autor;
import com.alura.literalura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutorController {

    @Autowired
    private AutorService autorService;

    public void listarAutoresVivosNoAno(int ano) {
        List<Autor> autoresVivos = autorService.listarAutoresVivosNoAno(ano);
        System.out.println("Autores vivos no ano " + ano + ":");
        for (Autor autor : autoresVivos) {
            System.out.println(autor);
        }
    }

    public void buscarAutorPorNome(String nome) {
        List<Autor> autores = autorService.buscarAutorPorNome(nome);
        System.out.println("Autores com o nome " + nome + ":");
        for (Autor autor : autores) {
            System.out.println(autor);
        }
    }
}
