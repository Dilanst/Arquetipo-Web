package com.latam.reserva.view;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.latam.reserva.utils.Configuracion;
import com.latam.reserva.utils.SeleniumUtils;

/**
 * <pre>
 * Fecha      Autor     
 * 17-11-2018 Dilan Steven Mejia	
 * </pre>
 * 
 * <p>Page Object que permite interacturar con los componentes de la 
 * pantalla Medio de pago
 * </p>
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category View
 * **/
public class MedioPagoView {

	
	
	@FindBy(id="chk_ok")
	private  WebElement checkTerminosCOndiciones;
	
	@FindBy(id="titulo_grupo_mp_caja_contenido_DIGITALCASHIER")
	private  WebElement btnMedioPago;
	
	
	@FindBy(name="next_step")
	private  WebElement btnConinuar;
	

	public MedioPagoView() {
		SeleniumUtils.esperarElemento(".union-title-table-paso3","css",30);
		PageFactory.initElements(Configuracion.driver, this);
	}

	/**
	 * <pre>
	 * Fecha      Autor     
	 * 17-11-2018 Dilan Steven Mejia	
	 * </pre>
	 * 
	 * Se selecciona el metodo de pago tarjeta de credito
	 * 
	 * @author Dilan Steven Mejia
	 * @param  reserva Datos de la reserva
	 * @return retorna la pantalla Medio de pago
	 * **/
	public MedioPagoView seleccionarMedioPagoTarjetaCredito() {
		btnMedioPago.click();
		SeleniumUtils.scrollElemento(btnConinuar);
		checkTerminosCOndiciones.click();
		btnConinuar.click();
		return this;
	}  
	
	public DetalleMedioPagoView detalleMedioPago() {
		return new DetalleMedioPagoView();
	}
}
