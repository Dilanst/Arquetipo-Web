package com.latam.reserva.dal.dto;

public class ReservaDTO {

	private String ciudadOrigen;
	private String ciudadDestino;
	private String fechaIda;
	private String fechaRegreso;
	private String nombre;
	private String apellido;
	private String numeroDocumento;
	private String email;
	private String telefonoArea;
	private String telefono;
	private DetallePagoDTO detallePago;
	
	public String getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public String getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	public String getFechaIda() {
		return fechaIda;
	}
	public void setFechaIda(String fechaIda) {
		this.fechaIda = fechaIda;
	}
	public String getFechaRegreso() {
		return fechaRegreso;
	}
	public void setFechaRegreso(String fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefonoArea() {
		return telefonoArea;
	}
	public void setTelefonoArea(String telefonoArea) {
		this.telefonoArea = telefonoArea;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public DetallePagoDTO getDetallePago() {
		return detallePago;
	}
	public void setDetallePago(DetallePagoDTO detallePago) {
		this.detallePago = detallePago;
	}

}
