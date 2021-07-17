package com.latam.reserva.test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.latam.reserva.bc.RealizarReservaBC;
import com.latam.reserva.dal.ReservaDAL;
import com.latam.reserva.dal.dto.ReservaDTO;
import com.latam.reserva.utils.Configuracion;
import com.latam.reserva.utils.PATH;

/**
 * <pre>
 * Fecha      Autor     
 * 17-11-2018 Dilan Steven Mejia	
 * </pre>
 * 
 * Se realiza el proceso de reservar de un vuelo hasta la pantalla de 
   metodo de pago donde se seleccionará el tipo de pago Tarjeta de credito. 
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category Test
 * **/

public class CP_1_Seleccionar_Metodo_Pago_Reserva_Test {
	
	ArrayList<ReservaDTO> dataPool = new ArrayList<ReservaDTO>();
	
	//Ingresa la configuracion del navegador,la url, y la ruta del archivo de la data	
	public void setup(){
		Configuracion.iniciarConfiguracion();
		this.dataPool = ReservaDAL.obtenerReservas(PATH.DATA_POOL);
	}

	/**
	 * <pre>
	 * Fecha      Autor     
	 * 17-11-2018 Dilan Steven Mejia	
	 * </pre>
	 * 
	 * Ejecuta el caso de prueba de realizar una reserva.
	 * 
	 * @author Dilan Steven Mejia
	 * 
	 * **/
	@Test
	public void seleccionarMetodoPago() {
		setup();
		for (ReservaDTO reserva : dataPool) {
			/*Enviar cada objeto que contiene el escenario*/
			  assertEquals(RealizarReservaBC.seleMetodoPagoTarjetaCredito(reserva).isTransaccionExitosa(),true);
		}

	}

	//Se cierran las sesiones del driver.
	@AfterSuite
	public void stopAllDrivers() {
		Configuracion.driver.quit();
	}

}
