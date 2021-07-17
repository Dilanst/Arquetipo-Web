package com.latam.reserva.dal.dto;

public class ResponseDTO {
	
	private boolean transaccionExitosa;
	private String mensajePantalla;
	
	public ResponseDTO(boolean transaccionExitosa,String mensajePantalla) {
		this.transaccionExitosa = transaccionExitosa;
		this.mensajePantalla = mensajePantalla;
	}

	public boolean isTransaccionExitosa() {
		return transaccionExitosa;
	}
	public void setTransaccionExitosa(boolean transaccionExitosa) {
		this.transaccionExitosa = transaccionExitosa;
	}
	public String getMensajePantalla() {
		return mensajePantalla;
	}
	public void setMensajePantalla(String mensajePantalla) {
		this.mensajePantalla = mensajePantalla;
	}
	
	
}
