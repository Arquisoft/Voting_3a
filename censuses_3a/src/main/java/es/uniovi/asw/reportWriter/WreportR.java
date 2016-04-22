package es.uniovi.asw.reportWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase que registra las incidencias en un fichero de LOG
 * para que éstas puedan ser reportadas
 * 
 * Patrón Singleton
 * 
 * @author Dario Rodríguez García (@dariorg)
 *
 */
public class WreportR implements WriteReport{
	
	private static WreportR logger = null;
	
	private WreportP wReport;
	
	private WreportR(){
		wReport = new WreportP();
	}
	
	public static WreportR getInstance(){
		if(logger == null){
			logger = new WreportR();
		}
		return logger;
	}
	
	public void writeReport(String fichero, Exception e){
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/main/resources/log.txt", true)))) {
			String line = "[" + wReport.getFormat().format(wReport.getDate()) + "]" + " FILE: " + fichero + " EXCEPTION TRACE: " + e.getMessage();
		    out.println(line);
		}catch (IOException ex) {
		   ex.printStackTrace();
		}
	}

}
