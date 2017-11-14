package com.marco.calendar;

import java.util.function.Predicate;

public final class Calendario {

	private static Calendario calendario;

	private Predicate<Integer> annioValido = anno -> anno > 1582;
	private Predicate<Integer> mesValido = mes -> mes < 13 && mes > 0;
	private Predicate<Fecha> diaDeMesValido = (Fecha fecha) -> fecha.obtenerDia() > 0
			&& fecha.obtenerDia() <= diasMaxMes(fecha);

	private Calendario() {
	}

	public static final Calendario obtenerCalendario() {
		return (calendario == null ? new Calendario() : calendario);
	}

	public boolean esBisiesto(int anno) {
		return anno % 4 == 0 && (anno % 100 != 0 || anno % 400 == 0);
	}

	public boolean esFechaValida(int anno, int mes, int dia) {
		return annioValido.test(anno) && mesValido.test(mes) && diaDeMesValido.test(new Fecha(anno, mes, dia));
	}

	public boolean esFechaValida(Fecha fecha) {
		return this.esFechaValida(fecha.obtenerAnno(), fecha.obtenerMes(), fecha.obtenerDia());
	}

	public Fecha diaSiguiente(Fecha fecha) {
		Fecha nueva = null;
		if (esFechaValida(fecha)) {
			Integer dia = (fecha.obtenerDia() == diasMaxMes(fecha) ? 1 : fecha.obtenerDia() + 1);
			Integer mes = (dia == 1 && fecha.obtenerMes() == 12) ? 1
					: (dia == 1 ? fecha.obtenerMes() + 1 : fecha.obtenerMes());
			Integer anno = (dia == 1 && mes == 1) ? fecha.obtenerAnno() + 1 : fecha.obtenerAnno();
			nueva = new Fecha(anno, mes, dia);
		}
		return nueva;
	}

	public Fecha diaAnterior(Fecha fecha) {
		Fecha nueva = null;
		if (esFechaValida(fecha)) {
			Integer dia = (fecha.obtenerDia() == 1 && fecha.obtenerMes() == 1 ? diasMaxMes(12, fecha.obtenerAnno() - 1)
					: (fecha.obtenerDia() == 1 ? diasMaxMes(fecha.obtenerMes() - 1, fecha.obtenerAnno())
							: fecha.obtenerDia() - 1));
			Integer mes = (dia == diasMaxMes(12, fecha.obtenerAnno() - 1) ? 12
					: (dia == diasMaxMes(fecha.obtenerMes() - 1, fecha.obtenerAnno()) ? fecha.obtenerMes() - 1
							: fecha.obtenerMes()));
			Integer anno = (mes == 12 && dia == diasMaxMes(12, fecha.obtenerAnno() - 1) ? fecha.obtenerAnno() - 1
					: fecha.obtenerAnno());
			nueva = new Fecha(anno, mes, dia);
		}
		return nueva;
	}

	public Integer diaSemana(Fecha fecha) {
		Integer diaS = -1;
		if (esFechaValida(fecha)) {
			int anno = fecha.obtenerAnno(), mes = fecha.obtenerMes(), dia = fecha.obtenerDia();
			int[] meses = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
			anno -= mes < 3 ? 1 : 0;
			diaS = (anno + anno / 4 - anno / 100 + anno / 400 + meses[mes - 1] + dia) % 7;
		}
		return diaS;
	}

	public Fecha fechaFutura(Fecha fecha, Integer cantDias) {
		Fecha nueva = new Fecha(fecha);
		for (int i = 0; i < cantDias; i++) {
			nueva = diaSiguiente(nueva);
		}
		return nueva;
	}

	public Fecha fechaPasada(Fecha fecha, Integer cantDias) {
		Fecha nueva = new Fecha(fecha);
		for (int i = 0; i < cantDias; i++) {
			nueva = diaAnterior(nueva);
		}
		return nueva;
	}

	private Integer diasMaxMes(Fecha fecha) {
		int dias = 0;
		switch (fecha.obtenerMes()) {
		case 2:
			dias = this.esBisiesto(fecha.obtenerAnno()) ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 31;
			break;
		}

		return dias;
	}

	private Integer diasMaxMes(Integer mes, Integer anno) {
		int dias = 0;
		Fecha fechaTemp = new Fecha(anno, mes, 1);
		dias = this.diasMaxMes(fechaTemp);
		return dias;
	}

}
