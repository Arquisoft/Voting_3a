package es.uniovi.asw.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.reportWriter.WreportR;

/**
 * Clase que permite cargar los datos de los votantes de un fichero Excel
 * 
 * @author Dario Rodriguez Garcia (@dariorg)
 * @version 2016.02.09
 *
 */
public class LoadFromExcel {
	
	/**
	 * Método que permite cargar los datos de los votantes de un censo
	 * 
	 * @param fichero - Nombre del fichero del que cargar datos
	 * @return - Lista con los votantes de un censo, cargados con sus datos
	 * @throws IOException
	 */
	public List<Voter> loadUsers( String fichero ) throws IOException {
		
		assertFileExtension(fichero);
		assertExistFile(fichero);
		
		List<Voter> voters = new ArrayList<Voter>();
		FileInputStream file = new FileInputStream( new File( fichero ) );
		
		//Obtenemos la hoja de votantes del censo
		XSSFWorkbook listaVotantes = new XSSFWorkbook( file ); 
		
		 //Obtenemos la primera hoja del libro excel
		XSSFSheet hoja = listaVotantes.getSheetAt(0);
		
		//Iteramos sobre cada fila de la primera hoja
		Iterator<Row> rowIterator = hoja.iterator(); 
	    rowIterator.next();
	    while( rowIterator.hasNext() ) {
	        Row row = rowIterator.next();
	        
	        //Para cada fila, iteramos a través de cada una de sus columnas
	        Iterator<Cell> columnas = row.cellIterator(); 
	        loadDataVoter( fichero, columnas, voters ); //Cargamos los datos del votante
	    }
	    listaVotantes.close();
		return voters;
	}


	private void loadDataVoter( String file, Iterator<Cell> columnas, List<Voter> voters ) {
		String nombre= null, dni, email = null;
		int pollingStationCode;
		Voter voter = null;
		try{
			nombre = columnas.next().getStringCellValue();
			email = columnas.next().getStringCellValue();
			dni = columnas.next().getStringCellValue();
			pollingStationCode = (int) columnas.next().getNumericCellValue();
			voter = new Voter(nombre, email, null, dni, pollingStationCode);
			voters.add(voter);
		}catch(NoSuchElementException ne){
			WreportR.getInstance()
			.writeReport(file, 
					new IllegalStateException("Número de campos incorrectos en fila: " + nombre + " " + email));
		}catch(IllegalStateException | NumberFormatException ne){
			WreportR.getInstance().writeReport(file, 
					new IllegalStateException("El campo colegio debe ser de tipo numérico"));
		}
	}
	
	private FileInputStream assertExistFile(String fichero) {
		FileInputStream in;
		try{
			in = new FileInputStream( new File( fichero ) );
		}catch(FileNotFoundException fnfe){
			throw new IllegalArgumentException("No se encuentra el fichero especificado");
		}
		return in;
	}

	private void assertFileExtension(String fichero) {
		if(! fichero.contains("xlsx")){
			throw new IllegalArgumentException("El fichero especificado no es un fichero Excel (xlsx)");
		}
	}

}
