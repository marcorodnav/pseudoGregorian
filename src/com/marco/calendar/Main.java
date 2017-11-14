package com.marco.calendar;

public class Main {
	public static void main(String[] args) {
		Calendario calendario = Calendario.obtenerCalendario();
		
		Fecha manana = calendario.diaSiguiente(new Fecha(2017,11,14));
		System.out.println(manana.obtenerFechaGregoriana("/"));
		System.out.println(manana.obtenerFechaGregoriana());
		System.out.println(manana);
		System.out.println(calendario.diaSemana(new Fecha(2017,11,13)));
	}
}
