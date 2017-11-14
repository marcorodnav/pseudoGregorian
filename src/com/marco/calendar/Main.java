package com.marco.calendar;

public class Main {
	public static void main(String[] args) {
		Calendario calendario = Calendario.obtenerCalendario();
		
		Fecha hoy = new Fecha(2017, 1, 1);
		Fecha pasada = calendario.fechaPasada(hoy, 30);
		System.out.println("Pasada con pasada 15 dias: "+ pasada.obtenerFechaGregoriana("/"));
	}
}
