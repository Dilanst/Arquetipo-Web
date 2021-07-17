package com.latam.reserva.view;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.latam.reserva.dal.dto.ReservaDTO;
import com.latam.reserva.utils.Configuracion;
import com.latam.reserva.utils.SeleniumUtils;

/**
 * <pre>
 * Fecha      Autor     
 * 17-11-2018 Dilan Steven Mejia	
 * </pre>
 * 
 * <p>Page Object que permite interacturar con los componentes de la 
 * pantalla Información del pasajero
 * </p>
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category View
 * **/
public class InformacionPasageroView{

	@FindBy(xpath="//section[@id = 'adult-0']//input[starts-with(@id,'name')]")
	private  WebElement inputNombre;

	@FindBy(xpath="//section[@id = 'adult-0']//input[starts-with(@id,'surname')]")
	private  WebElement inputApellido;

	@FindBy(xpath="//section[@id = 'adult-0']//input[starts-with(@id,'document-number')]")
	private  WebElement inputNumeroDocumento;

	@FindBy(xpath="//section[@id = 'contact']//input[starts-with(@id,'email')]")
	private  WebElement inputEmail;

	@FindBy(xpath="//section[@id = 'contact']//input[starts-with(@id,'phone-area-code')]")
	private  WebElement inputTelefonoArea;

	@FindBy(xpath="//section[@id = 'contact']//input[starts-with(@id,'phone-number')]")
	private  WebElement inputTelefono;

	@FindBy(css=".form-container button")
	private  WebElement btnConinuar;

	public InformacionPasageroView() {
		SeleniumUtils.esperarElemento("//section[@id = 'adult-0']//input[starts-with(@id,'name')]","xpath",30);
		PageFactory.initElements(Configuracion.driver, this);
	}

	/**
	 * <pre>
	 * Fecha      Autor     
	 * 17-11-2018 Dilan Steven Mejia	
	 * </pre>
	 * 
	 * Se ingresan los datos del pasajero
	 * 
	 * @author Dilan Steven Mejia
	 * @param  reserva Datos de la reserva
	 * @return retorna la pantalla información pasajero
	 * **/
	public InformacionPasageroView ingresarInformacionPasajero(ReservaDTO reserva) {
		inputNombre.sendKeys(reserva.getNombre());
		inputApellido.sendKeys(reserva.getApellido());
		inputNumeroDocumento.sendKeys(reserva.getNumeroDocumento());
		inputEmail.sendKeys(reserva.getEmail());
		inputTelefonoArea.sendKeys(reserva.getTelefonoArea());
		inputTelefono.sendKeys(reserva.getTelefono());
		SeleniumUtils.scrollElemento(btnConinuar);
		btnConinuar.click();
		return this;
	}

	public SeleccionarSillaView seleccionarSillaView() {
		return new SeleccionarSillaView();
	}

}
