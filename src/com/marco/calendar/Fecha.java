package com.marco.calendar;

public class Fecha {
	private Integer anno;
	private Integer mes;
	private Integer dia;

	public Fecha(int anno, int mes, int dia) {
		this.anno = anno;
		this.mes = mes;
		this.dia = dia;
	}
	
	public Fecha() {
		this(1582,1,1);
	}
	
	public Fecha(Fecha fecha) {
		this.anno = fecha.obtenerAnno();
		this.mes = fecha.obtenerMes();
		this.dia = fecha.obtenerDia();
	}

	public int obtenerAnno() {
		return this.anno;
	}

	public int obtenerMes() {
		return this.mes;
	}

	public int obtenerDia() {
		return this.dia;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("(").append(this.anno).append(",").append(this.mes).append(",")
				.append(this.dia).append(")").toString();
	}

	public String obtenerFechaGregoriana() {
		return String.join("", this.anno.toString(), this.mes.toString(), this.dia.toString());
	}

	public String obtenerFechaGregoriana(String separador) {
		return String.join(separador, this.anno.toString(), this.mes.toString(), this.dia.toString());
	}
}
