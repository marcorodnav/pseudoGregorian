package com.marco.calendar;

public class Main {
	public static void main(String[] args) {
		Calendario calendario = Calendario.obtenerCalendario();
		
		Fecha fecha0 = new Fecha(2017, 3, 28);
		Fecha fecha1 = new Fecha(3050, 3, 28);
		long inicio = System.currentTimeMillis();
		Integer dias = calendario.diasEntre(fecha0, fecha1);
		long fin = System.currentTimeMillis();
		System.out.println(dias);
		System.out.println("Tiempo: "+ (fin - inicio) + " ms");
	}
}
