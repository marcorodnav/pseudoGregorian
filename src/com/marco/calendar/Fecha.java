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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anno == null) ? 0 : anno.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		if (anno == null) {
			if (other.anno != null)
				return false;
		} else if (!anno.equals(other.anno))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		return true;
	}
	
	public Boolean esMenor(Fecha that) {
		return (this.obtenerAnno() < that.obtenerAnno() || this.obtenerMes() < that.obtenerMes()
				|| this.obtenerDia() < that.obtenerDia());
	}
	
	public String obtenerFechaGregoriana() {
		return String.join("", this.anno.toString(), this.mes.toString(), this.dia.toString());
	}

	public String obtenerFechaGregoriana(String separador) {
		return String.join(separador, this.anno.toString(), this.mes.toString(), this.dia.toString());
	}
}
