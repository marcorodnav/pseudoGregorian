package com.marco.calendar;

public class Main {
	public static void main(String[] args) {
		Calendario calendario = Calendario.obtenerCalendario();
		
		System.out.println("Todas las fechas son manejadas como tuplas de tres números enteros\npositivos (ternas), en el siguiente orden: (año, mes, día).");
		Fecha fechaTupla = new Fecha(2017, 11, 14);
		System.out.println("Fecha ejemplo: "+fechaTupla);
		
		System.out.println("\nMetodo esBisiesto:");
		Integer bisiesto = 2016;
		Integer noBisiesto = 2017;
		System.out.println("Bisiesto: 2016 = "+ calendario.esBisiesto(bisiesto));
		System.out.println("No Bisiesto: 2017 = "+ calendario.esBisiesto(noBisiesto));
		
		System.out.println("\nMetodo esFechaValida:");
		Fecha fechaValida = new Fecha(2017,11,1);
		Fecha fechaNoValida = new Fecha(2017,13,55);
		System.out.println("Fecha valida: "+fechaValida+" = "+calendario.esFechaValida(fechaValida));
		System.out.println("Fecha no valida: "+fechaNoValida+" = "+calendario.esFechaValida(fechaNoValida));
		
		System.out.println("\nMetodo diaSiguiente:");
		Fecha fechaHoy = new Fecha(2017,11,14);
		Fecha fechaManana = calendario.diaSiguiente(fechaHoy);
		System.out.println("Fecha hoy: "+ fechaHoy + "\nFecha manana: "+ fechaManana);
		
		System.out.println("\nMetodo diaSemana:");
		Integer diaSemana = calendario.diaSemana(fechaHoy);
		System.out.println("Codificacion de dias de la semana:");
		System.out.println("0 = domingo, 1 = lunes, 2 = martes, 3 = miércoles, 4 = jueves, 5 = viernes, 6 = sábado");
		System.out.println("Dia de hoy = "+ diaSemana);
		
		System.out.println("\nMetodo fechaFutura:");
		Fecha fechaDentro15Dias = calendario.fechaFutura(fechaHoy, 15);
		System.out.println("Fecha dentro de 15 dias: "+ fechaDentro15Dias);
		
		//TODO: REVISAR FECHA_PASADA
		System.out.println("\nMetodo fechaPasada:");
		fechaHoy = new Fecha(2017,11,14);
		Fecha fechaHace15Dias = calendario.fechaPasada(fechaHoy, 20);
		System.out.println("Fecha hace de 15 dias: "+ fechaHace15Dias);
	}
}
