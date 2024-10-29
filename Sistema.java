package pacote;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Quarto {
	private int qua;
	private int tipo;
	private int hos;
	private double dia;
	private int status;
	
	public Quarto(int qua, int tipo, int hos, double dia, int status) {
		this.qua = qua;
		this.tipo = tipo;
		this.hos = hos;
		this.dia = dia;
		this.status = status;
	}
	
	public int getQua() {
		return qua;
	}
	public int getTipo() {
		return tipo;
	}
	public int getHos() {
		return hos;
	}
	public double getDia() {
		return dia;
	}
	public int getStatus() {
		return status;
	}
}

class Hotel {
	
	private List<Quarto> quartos;
	
	public Hotel() {
		quartos = new ArrayList<>();
	}
	
	public void addQuarto(Quarto quarto) {
		quartos.add(quarto);
	}
	public void listQuarto() {
		System.out.println("\nQuartos cadastrados:");
		for (Quarto quarto : quartos) {
			System.out.println(quarto);
		}
	}
}

class Cadastro {
	private Hotel hotel;
	private Scanner sc;
	
	public Cadastro(Hotel hotel) {
		this.hotel = hotel;
		this.sc = new Scanner(System.in);
	}
	
	public void cadastrar() {
		
		Scanner sc = new Scanner(System.in);
		boolean valid = false;
		System.out.println("CADASTRO DE NOVO QUARTO\nInforme o número do quarto:");
		int qua = sc.nextInt();
		while(!valid) {
			try{
				System.out.println("\nInforme o tipo de quarto:\n(1) Solteiro\n(2) Casal\n(3) Suíte");
				int tipo = sc.nextInt();
				if (tipo > 3 || tipo < 1) {
					System.out.println("\nInforme um número válido.\n");
				} else {
					valid = true;
				}
			} catch(InputMismatchException e) {
				System.out.println("\nInforme um número válido");
				sc.next();
			}
		}
		System.out.println("\nInforme a capacidade do quarto em número de hóspedes:");
		try{
			int hos = sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("Informe um número válido.");
			sc.next();
		}
		try{
			System.out.println("\nInforme o preço da diária:");
			double dia = sc.nextDouble();
		} catch(InputMismatchException e) {
			System.out.println("Informe um número válido.");
			sc.next();
		}
		int status = 1;
		sc.close();
	}
}

public class Sistema{
	public static void main(String[] args) {
		
	}
}