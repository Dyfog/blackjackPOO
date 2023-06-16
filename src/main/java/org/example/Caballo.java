package org.example;

public class Caballo {
	private int id;
	private String color;
	private String nombre;


	public int getId() {
		return id;
	}

	public String getColor() {
		return color;
	}

	public String getNombre() {
		return nombre;
	}

	public Caballo(int id, String color, String nombre) {
		this.id = id;
		this.color = color;
		this.nombre = nombre;
	}
}
