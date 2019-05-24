package application;


import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Conta;
import model.exceptions.DomainException;

public class ProgramConta {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {

			System.out.println("Digite os dados da conta:  ");
			System.out.print("Numero:");
			Integer num = sc.nextInt();
			System.out.print("Nome do correntista:");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Saldo Inicial:");
			Double saldo = sc.nextDouble();
			System.out.print("Limite de Saque:");
			Double limiteSaque = sc.nextDouble();
			
			Conta conta = new Conta(num, nome, saldo, limiteSaque);
			
			System.out.println();
			System.out.print("Digite o valor do Saque:");
			Double saque = sc.nextDouble();
			
			conta.saque(saque);
			System.out.print("Saldo Atual:" + String.format("%.2f", conta.getSaldo()));
			
			
			
			
		}
		catch(DomainException e){
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Dado digitado incorretamente!");
			
		}
		catch(RuntimeException e) {

			System.out.println("Erro Inesperado");
		}
		
		sc.close();
}
}
