package com.latam.reserva.view;

import java.util.List;

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
 * pantalla Seleccionar un vuelo
 * </p>
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category View
 * **/
public class SeleccionarVueloView {

	@FindBy(css=".price-button .value span")
	private  List<WebElement> listPreciosVuelos;



	public SeleccionarVueloView() {
		esperarPantallaCargar();
		PageFactory.initElements(Configuracion.driver, this);

	}


	public void esperarPantallaCargar() {
		SeleniumUtils.esperarElemento(".price-button-wrapper","css",30);
	}

	public SeleccionarVueloView seleccionarPrecioOrigen() {
		esperarPantallaCargar();
		listPreciosVuelos.get(0).click();
		btnSeleccionarVuelo();
		return this;
	}

	public SeleccionarVueloView seleccionarPrecioOrigenEconomico() {
		esperarPantallaCargar();
		obtenerPrecioEconomico().click();
		btnSeleccionarVuelo();
		return this;
	}

	public SeleccionarVueloView seleccionarPrecioDestino() {
		esperarPantallaCargar();
		listPreciosVuelos.get(0).click();
		btnSeleccionarVuelo();
		return this;
	}

	public SeleccionarVueloView seleccionarPrecioDestinoEconomico() {
		esperarPantallaCargar();
		obtenerPrecioEconomico().click();
		btnSeleccionarVuelo();
		return this;
	}


	//Se da click en continuar una vez se selecciona el tiquete mas barato
	private void btnSeleccionarVuelo() {
		SeleniumUtils.esperarAnimacionElemento();
		WebElement btnSeleccionarVuelo = SeleniumUtils.esperarElemento(".collapsable-information-navigation button","css");
		SeleniumUtils.scrollElemento(btnSeleccionarVuelo);
		btnSeleccionarVuelo.click();

	}

	//Se selecciona el tiquete mas economico
	private  WebElement obtenerPrecioEconomico() {
		WebElement btnPrecioEconomico = listPreciosVuelos.get(0);
		for (int i = 1; i < listPreciosVuelos.size(); i++) {
			if(	Double.parseDouble(listPreciosVuelos.get(i).getText()) <
					Double.parseDouble(btnPrecioEconomico.getText())) { 
				btnPrecioEconomico = listPreciosVuelos.get(i);
			}
		}

		return btnPrecioEconomico;
	}

	public InformacionPasageroView informacionPasagero() {
		return new InformacionPasageroView();
	}

}
