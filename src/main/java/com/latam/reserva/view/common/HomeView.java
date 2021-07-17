package com.latam.reserva.view.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.latam.reserva.dal.dto.ReservaDTO;
import com.latam.reserva.utils.Configuracion;
import com.latam.reserva.utils.SeleniumUtils;
import com.latam.reserva.view.SeleccionarVueloView;

/**
 * <pre>
 * Fecha      Autor     
 * 17-11-2018 Dilan Steven Mejia	
 * </pre>
 * 
 * <p>Page Object que permite interacturar con los componentes de la 
 * pantalla de inicio de LATAM
 * </p>
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category View
 * **/
public class HomeView {

	@FindBy(id="compra-select-destination")
	private WebElement inputCiudadDestino;
	
	@FindBy(className="hasDatepicker")
	private List<WebElement> inputFechasVuelo;
	
	 public HomeView() {
		PageFactory.initElements(Configuracion.driver, this);
	}
	 
		/**
		 * <pre>
		 * Fecha      Autor     
		 * 17-11-2018 Dilan Steven Mejia	
		 * </pre>
		 * 
		 * Busca un vuelo 
		 * 
		 * @author Dilan Steven Mejia
		 * @param  reserva Datos de la reserva
		 * @return retorna la pantalla home
		 * 
		 * **/
	
	public  HomeView buscarVuelo(ReservaDTO reserva){
		
		WebElement btnPromo= SeleniumUtils.esperarElemento("onesignal-popover-cancel-button","id");
		btnPromo.click();
		WebElement inputCiudadOrigen = SeleniumUtils.esperarElemento("compra-select-origin","id");
		SeleniumUtils.scrollElemento(inputCiudadOrigen);
		inputCiudadOrigen.sendKeys(reserva.getCiudadOrigen());
		
		
		WebElement inputCiudadOrigenSelect = SeleniumUtils.esperarElemento(".compra__origin-region [role =presentation]","css");
		inputCiudadOrigenSelect.click();
		
		inputCiudadDestino.sendKeys(reserva.getCiudadDestino());
		
		WebElement inputCiudadDestinoSelect = SeleniumUtils.esperarElemento(".compra__destination-region [role =presentation]","css");
		inputCiudadDestinoSelect.click();
	
		inputFechasVuelo.get(0).click();
		SeleniumUtils.esperarAnimacionElemento();
		List<WebElement> inputFechasRegreso = Configuracion.driver.findElements
				(By.xpath("//table[@class ='ui-datepicker-calendar']//a[text() "
						+ "="+reserva.getFechaIda().split("/")[0]+"]"));
		inputFechasRegreso.get(0).click();
		
		
		inputFechasVuelo.get(1).click();
		SeleniumUtils.esperarAnimacionElemento();
		inputFechasRegreso = Configuracion.driver.findElements
				(By.xpath("//table[@class ='ui-datepicker-calendar']//a[text() "
						+ "="+reserva.getFechaRegreso().split("/")[0]+"]"));
		inputFechasRegreso.get(0).click();
		
		WebElement btnBuscarVuelo = SeleniumUtils.esperarElemento("#tab-compra .collapsible-panel .button","css");
		btnBuscarVuelo.click();
		return this;
	}
	
	public SeleccionarVueloView seleccionarVuelo(){
		return new SeleccionarVueloView();
	}
}
