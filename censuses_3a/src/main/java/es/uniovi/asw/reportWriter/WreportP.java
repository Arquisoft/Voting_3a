package es.uniovi.asw.reportWriter;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Añade a los datos la hora y la fecha a los campos que se almacenan
 * en el fichero de LOG
 * 
 * @author Darío Rodríguez García (@dariorg)
 *
 */
public class WreportP {
	
	private DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	private Date date;
	
	public WreportP() {
		date = new Date(System.currentTimeMillis());
	}
	
	public Date getDate() {
		return date;
	}
	
	public DateFormat getFormat() {
		return format;
	}

}
