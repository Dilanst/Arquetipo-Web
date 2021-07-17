package com.latam.reserva.bc;


import com.latam.reserva.dal.dto.ReservaDTO;
import com.latam.reserva.dal.dto.ResponseDTO;
import com.latam.reserva.view.common.HomeView;

/**
 * <pre>
 * Fecha      Autor     
 * 17-11-2018 Dilan Steven Mejia	
 * </pre>
 * 
 * Logica de negocio de la reserva. 
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category Business Component
 * **/


public class RealizarReservaBC {

	/**
	 * <pre>
	 * Fecha      Autor     
	 * 17-11-2018 Dilan Steven Mejia	
	 * </pre>
	 * 
	 * Se selecciona el metodo de pago por tarjeta de credito de una reserva
	 * 
	 * @author Dilan Steven Mejia
	 * @param  reserva Datos de la reserva
	 * @return respuesta del proceso realizado
	 * 
	 * **/
	
	

	public static ResponseDTO seleMetodoPagoTarjetaCredito(ReservaDTO reserva){
		try {
			new HomeView().
			buscarVuelo(reserva).
			seleccionarVuelo().
			seleccionarPrecioOrigenEconomico().
			seleccionarPrecioDestinoEconomico().
			informacionPasagero().
			ingresarInformacionPasajero(reserva).
			seleccionarSillaView().
			seleccionarSillaDespues().
			medioPagoView().
			seleccionarMedioPagoTarjetaCredito();

			return new ResponseDTO(true,"La selección del medio de pago fue exitosa");
		} catch (Exception e) {
			return new ResponseDTO(false,e.getMessage());
		}

	}


}
