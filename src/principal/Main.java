package principal;

import java.util.Scanner;

import controllers.PessoaController;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("\nSISTEMA DE GERENCIAMNETO DE PESSOA: \n");
		System.out.println("(1) CADASTRAR PESSOA:");
		System.out.println("(2) ATUALIZAR PESSOA");
		System.out.println("(3) EXCLUIR PESSOA");
		System.out.println("(4) CONSULTAR PESSOA");

		System.out.println("\nINFORME A OPÇÃO DESEJADA: ");
		var opcao = scanner.nextLine();

		var pessoaController = new PessoaController();

		switch (opcao) {
		case "1":
			pessoaController.cadastrarPessoa();
			break;
		case "2":
			pessoaController.atualizarPessoa();
		case "3":
			pessoaController.excluirPessoa();
		case "4":
			pessoaController.consultarPessoa();
		default:
			System.out.println("\nOpção Inválida");
		}
		System.out.println("\nDESEJA CONTINUAR? (S/N): ");
		var continuar = scanner.nextLine();
		
		if (continuar.equalsIgnoreCase("S")) {
			main(args);// RECURSIVIDADE
	}
	else {
		System.out.println("\nFIM DO PROGRAMA");
	}

}
}
