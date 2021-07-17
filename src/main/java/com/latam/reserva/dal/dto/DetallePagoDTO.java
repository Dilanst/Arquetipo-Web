package com.latam.reserva.dal.dto;

public class DetallePagoDTO {
	private String numeroTC;
	private String mes;
	private String anho;
	private String codigoSeguridad;
	private String nombreTitular;
	public String getNumeroTC() {
		return numeroTC;
	}
	public void setNumeroTC(String numeroTC) {
		this.numeroTC = numeroTC;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAnho() {
		return anho;
	}
	public void setAnho(String anho) {
		this.anho = anho;
	}
	public String getCodigoSeguridad() {
		return codigoSeguridad;
	}
	public void setCodigoSeguridad(String codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}
	public String getNombreTitular() {
		return nombreTitular;
	}
	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
}
