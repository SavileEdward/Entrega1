package entrega1;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		Funcionario funcionario = new Funcionario(null, 0, null, 0, null);
		System.out.print("Bem-vindo ao ");
		
		while (true) {
			try {
			System.out.println("Sistema de Gerenciamento de Funcionários\n\nDigite:\n(1) Para cadastrar"
					+ "  (2) Para visualizar os cadastros  (3) Para editar os cadastros  (4) Para remover um cadastro  (0) Para sair");
			op = sc.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("Opção inválida.");
			}
			if (op == 1) {
				funcionario.cadastro();
			} else if (op == 2) {
				funcionario.view();
			} else if(op == 3) {
				funcionario.edit();	
			} else if(op == 4) {
				funcionario.remove();
			} else if (op == 0) {
				System.out.println("Saindo . . .");
				break;
			} else {
				System.out.println("Opção inválida.");
			}
			
		}
		sc.close();
	}	
}
