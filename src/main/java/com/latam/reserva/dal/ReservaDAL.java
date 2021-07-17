package com.latam.reserva.dal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.latam.reserva.dal.dto.DetallePagoDTO;
import com.latam.reserva.dal.dto.ReservaDTO;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 * <pre>
 * Fecha      Autor     
 * 17-11-2018 Dilan Steven Mejia	
 * </pre>
 * 
 * Obtener información de cada una de las reservas
 * 
 * @author Dilan Steven Mejia
 * @version 1.0
 * @category DAL
 * **/

public class ReservaDAL {

	/**
	 * <pre>
	 * Fecha      Autor     
	 * 17-11-2018 Dilan Steven Mejia	
	 * </pre>
	 * 
	 * Hidrata la reserva con cada una de las filas de un excel.
	 * 
	 * @author Dilan Steven Mejia
	 * @return Lista de reservas
	 * 
	 * **/

	public static  ArrayList<ReservaDTO> obtenerReservas(String dataPool){
		ArrayList<ReservaDTO> listReservasDTO = new ArrayList<ReservaDTO>();
		try {
			Workbook excelDataPool = Workbook.getWorkbook(new File(dataPool));
			Sheet hojaExcelDataPool = excelDataPool.getSheet(0);


			for (int fila = 1; fila < hojaExcelDataPool.getRows(); fila++) {
				ReservaDTO  reserva = new ReservaDTO();
				DetallePagoDTO detallePagoDTO = new DetallePagoDTO();

				reserva.setCiudadOrigen(validarDato(hojaExcelDataPool	,"ciudadOrigen"		,fila));
				reserva.setCiudadDestino(validarDato(hojaExcelDataPool	,"ciudadDestino"	,fila));
				reserva.setFechaIda(validarDato(hojaExcelDataPool		,"fechaIda"			,fila));
				reserva.setFechaRegreso(validarDato(hojaExcelDataPool	,"fechaRegreso"		,fila));
				reserva.setNombre(validarDato(hojaExcelDataPool			,"nombre"			,fila));
				reserva.setApellido(validarDato(hojaExcelDataPool		,"apellido"			,fila));
				reserva.setNumeroDocumento(validarDato(hojaExcelDataPool,"numeroDocumento"	,fila));
				reserva.setEmail(validarDato(hojaExcelDataPool			,"email"			,fila));
				reserva.setTelefonoArea(validarDato(hojaExcelDataPool	,"telefonoArea"		,fila));
				reserva.setTelefono(validarDato(hojaExcelDataPool		,"telefono"			,fila));

				detallePagoDTO.setNumeroTC(validarDato(hojaExcelDataPool		,"numeroTC"			,fila));
				detallePagoDTO.setMes(validarDato(hojaExcelDataPool				,"mes"				,fila));
				detallePagoDTO.setAnho(validarDato(hojaExcelDataPool			,"anho"				,fila));
				detallePagoDTO.setCodigoSeguridad(validarDato(hojaExcelDataPool	,"codigoSeguridad"	,fila));
				detallePagoDTO.setNombreTitular(validarDato(hojaExcelDataPool	,"nombreTitular"	,fila));

				reserva.setDetallePago(detallePagoDTO);

				listReservasDTO.add(reserva);
			}

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listReservasDTO;
	}

	/**
	 * <pre>
	 * Fecha      Autor     
	 * 17-11-2018 Dilan Steven Mejia	
	 * 
	 * </pre>
	 * 
	 * Valida que si hay un elemento en la celda, sino retorna vacio.
	 * 
	 * @author Dilan Steven Mejia
	 * @return Elemento encontrado en la celda
	 * 
	 * **/

	public static String validarDato(Sheet hojaExcelDataPool,String campo,int fila){
		try {
			return hojaExcelDataPool.getCell(hojaExcelDataPool.findCell(campo).getColumn(),fila).getContents();

		} catch (Exception e) {

			return "";
		}


	}


}
