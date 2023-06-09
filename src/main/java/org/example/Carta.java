package org.example;

public class Carta {

	private String pinta;
	private char indice;
	private int valor;

	public String getPinta() {
		return this.pinta;
	}

	public char getIndice() {
		return this.indice;
	}

	public int getValor() {
		return this.valor;
	}

	public Carta(String pinta, char indice, int valor) {
		this.pinta = pinta;
		this.indice = indice;
		this.valor = valor;
	}
}