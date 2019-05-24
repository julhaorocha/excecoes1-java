package model.entities;

import model.exceptions.DomainException;

public class Conta {
	
	private Integer num;
	private String nome;
	private Double saldo;
	private Double limiteSaque;
	
	public Conta() {
		
	}

	public Conta(Integer num, String nome, Double saldo, Double limiteSaque) {
		this.num = num;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public Double getSaldo() {
		return saldo;
	}
	public void deposito(Double deposito) {
		saldo += deposito;
		
	}
	public void saque(Double saque) {
		if ( saque > limiteSaque) {
			throw new DomainException("O valor digitado excedeu ao limite de saque");
		}else if(saldo > saque) {
			saldo -= saque;
		}else {
			throw new DomainException("Não há saldo suficiente para realizar o saque.");
		}
	}
	
	

}
