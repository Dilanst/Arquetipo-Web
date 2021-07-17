package com.latam.reserva.view;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.latam.reserva.dal.dto.DetallePagoDTO;
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
 * pantalla Detalle de pago
 * </p>
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category View
 * **/


public class DetalleMedioPagoView {
	
	@FindBy(name="number")
	private  WebElement inputNumeroTC;

	@FindBy(name="month")
	private  WebElement inputMes;

	@FindBy(name="year")
	private  WebElement inputAnho;

	@FindBy(name="security-code")
	private  WebElement inputSC;
	
//installmentsField select numero cuotas value 1	
	
	@FindBy(name="field")
	private  WebElement inputNombreTitular;	
	
	@FindBy(name="next_step")
	private  WebElement btnConinuar;

	public DetalleMedioPagoView() {
		SeleniumUtils.esperarElemento("number","name",30);
		PageFactory.initElements(Configuracion.driver, this);
	}
	
	/**
	 * <pre>
	 * Fecha      Autor     
	 * 17-11-2018 Dilan Steven Mejia	
	 * </pre>
	 * 
	 * Se ingresan los datos del detalle de la tarjeta de credito
	 * (No se implementa porque LATAM detecta que se usa un robot y aveces no
	 * habilita la pagina)
	 * 
	 * @author Dilan Steven Mejia
	 * @param  reserva Datos de la reserva
	 * @return retorna la pantalla Detalle del medio de pago
	 * **/
	public DetalleMedioPagoView ingresarDetalleMedioPago(DetallePagoDTO detalle)  {
		inputNumeroTC.sendKeys(detalle.getNumeroTC());
		inputMes.sendKeys(detalle.getMes());
		inputAnho.sendKeys(detalle.getAnho());
		inputSC.sendKeys(detalle.getCodigoSeguridad());
		return this;
	}

}
