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
 * pantalla Seleccionar silla
 * </p>
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category View
 * **/
public class SeleccionarSillaView {
	
	@FindBy(css=".skip-seats-button-desktop")
	private  WebElement btnSeleSillaDespues;
	

	public SeleccionarSillaView() {
		SeleniumUtils.esperarElemento(".flight-information","css",30);
		PageFactory.initElements(Configuracion.driver, this);
	}
	
	/**
	 * <pre>
	 * Fecha      Autor     
	 * 17-11-2018 Dilan Steven Mejia	
	 * </pre>
	 * 
	 * Se omite seleccionar una silla
	 * 
	 * @author Dilan Steven Mejia
	 * @param  reserva Datos de la reserva
	 * @return retorna la pantalla Seleccionar Silla
	 * **/
	public SeleccionarSillaView seleccionarSillaDespues() {
		btnSeleSillaDespues.click();
		return this;
	}
	
	public MedioPagoView medioPagoView() {
		return new MedioPagoView();
	}

}
