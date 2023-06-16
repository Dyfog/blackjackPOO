package org.example;

public class JugadorBullseye {
	private int dineroRestante;
	private String nombre;
	private int idCaballoElegido;

	public int getDineroRestante() {
		return dineroRestante;
	}

	public void setDineroRestante(int dineroRestante) {
		this.dineroRestante = dineroRestante;
	}

	public JugadorBullseye(String nombre) {
		this.dineroRestante = 50000;
		this.nombre = nombre;
	}

	public int getIdCaballoElegido() {
		return idCaballoElegido;
	}

	public void setIdCaballoElegido(int idCaballoElegido) {
		this.idCaballoElegido = idCaballoElegido;
	}
}
