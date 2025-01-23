package controllers;

import java.util.Scanner;

import entities.Pessoa;
import repositories.PessoaRepository;

// Classe de controle para prompt de açoes com pessoa
public class PessoaController {

	private Scanner scanner = new Scanner(System.in);

	public void cadastrarPessoa() {

		System.out.println("\nCADASTRO DE PESSOA");

		var pessoa = new Pessoa();

		System.out.println("INFORME O NOME DA PESSOA");
		pessoa.setNome(scanner.nextLine());

		System.out.println("INFORME O EMAIL DA PESSOA");
		pessoa.setEmail(scanner.nextLine());

		var pessoaRepository = new PessoaRepository();
		pessoaRepository.create(pessoa);

	}

	public void atualizarPessoa() {

		System.out.println("\nATULAIZAÇÃO DE PESSOA");

		var pessoa = new Pessoa();

		System.out.println("INFORME O ID DA PESSOA");
		pessoa.setId(Integer.parseInt(scanner.nextLine()));

		System.out.println("INFORME O NOME DA PESSOA");
		pessoa.setNome(scanner.nextLine());

		System.out.println("INFORME O EMAIL DA PESSOA");
		pessoa.setEmail(scanner.nextLine());

		var pessoaRepository = new PessoaRepository();
		pessoaRepository.update(pessoa);

	}

	public void excluirPessoa() {

		System.out.println("\nEXCLUSAO DE PESSOA\n");

		System.out.println("INFORME O ID DA PESSOA");
		var id = Integer.parseInt(scanner.nextLine());

		var pessoaRepository = new PessoaRepository();
		pessoaRepository.delete(id);

	}

	public void consultarPessoa() {

		System.out.println("\nCONSULTA DE PESSOA\n");

		var pessoaRepository = new PessoaRepository();
		var lista = pessoaRepository.findAll();

		for (var pessoa : lista) {

		
		System.out.println("Id.........:" + pessoa.getId());
		System.out.println("NOME.......:" + pessoa.getNome());
		System.out.println("EMAIL......:" + pessoa.getEmail());
		System.out.println("...");
	}
	}}
