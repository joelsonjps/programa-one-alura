package com.alura.literalura;

import com.alura.literalura.controller.LivroController;
import com.alura.literalura.controller.AutorController;
import com.alura.literalura.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LivroController livroController;

	@Autowired
	private AutorController autorController;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		exibirMenu();
	}

	private void exibirMenu() {
		Scanner scanner = new Scanner(System.in);
		boolean continuar = true;

		while (continuar) {
			String menu = """
                Escolha uma opção:
                1. Buscar livro por título
                2. Listar todos os livros
                3. Listar livros por idioma
                4. Listar autores vivos em determinado ano
                5. Gerar estatísticas sobre livros por idioma
                6. Top 10 livros mais baixados
                7. Buscar autor por nome
                0. Sair
                """;
			System.out.println(menu);

			int opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer

			switch (opcao) {
				case 1 -> buscarLivroPorTitulo(scanner);
				case 2 -> listarTodosOsLivros();
				case 3 -> listarLivrosPorIdioma(scanner);
				case 4 -> listarAutoresVivosNoAno(scanner);
				case 5 -> gerarEstatisticasPorIdioma(scanner);
				case 6 -> listarTop10LivrosMaisBaixados();
				case 7 -> buscarAutorPorNome(scanner);
				case 0 -> {
					continuar = false;
					System.out.println("Saindo...");
				}
				default -> System.out.println("Opção inválida. Tente novamente.");
			}
		}

		scanner.close();
	}

	private void buscarLivroPorTitulo(Scanner scanner) {
		System.out.println("Digite o título do livro:");
		String titulo = scanner.nextLine();
		try {
			Livro livro = livroController.buscarLivroPorTitulo(titulo);
			System.out.println("Livro encontrado:");
			System.out.println(livro);
		} catch (Exception e) {
			System.out.println("Erro ao buscar livro: " + e.getMessage());
		}
	}

	private void listarTodosOsLivros() {
		List<Livro> livros = livroController.listarTodosOsLivros();
		System.out.println("Listagem de todos os livros:");
		livros.forEach(System.out::println);
	}

	private void listarLivrosPorIdioma(Scanner scanner) {
		System.out.println("Digite o idioma:");
		String idioma = scanner.nextLine();
		List<Livro> livrosPorIdioma = livroController.listarLivrosPorIdioma(idioma);
		System.out.println("Listagem de livros no idioma " + idioma + ":");
		livrosPorIdioma.forEach(System.out::println);
	}

	private void listarAutoresVivosNoAno(Scanner scanner) {
		System.out.println("Digite o ano:");
		int ano = scanner.nextInt();
		scanner.nextLine(); // Limpar o buffer
		autorController.listarAutoresVivosNoAno(ano).forEach(System.out::println);
	}

	private void gerarEstatisticasPorIdioma(Scanner scanner) {
		System.out.println("Digite o idioma:");
		String idioma = scanner.nextLine();
		DoubleSummaryStatistics estatisticas = livroController.calcularEstatisticasPorIdioma(idioma);
		System.out.println("Estatísticas para o idioma " + idioma + ":");
		System.out.println("Média de downloads: " + estatisticas.getAverage());
		System.out.println("Total de downloads: " + estatisticas.getSum());
		System.out.println("Máximo de downloads: " + estatisticas.getMax());
		System.out.println("Mínimo de downloads: " + estatisticas.getMin());
	}

	private void listarTop10LivrosMaisBaixados() {
		System.out.println("Top 10 livros mais baixados:");
		livroController.listarTop10LivrosMaisBaixados().forEach(System.out::println);
	}

	private void buscarAutorPorNome(Scanner scanner) {
		System.out.println("Digite o nome do autor:");
		String nomeAutor = scanner.nextLine();
		autorController.buscarAutorPorNome(nomeAutor).forEach(System.out::println);
	}
}
