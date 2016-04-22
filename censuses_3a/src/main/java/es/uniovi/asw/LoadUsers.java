package es.uniovi.asw;

import es.uniovi.asw.parser.RCensus;
import es.uniovi.asw.parser.ReadCensus;

/**
 * Main application
 * 
 * @author Darío Rodríguez García (@dariorg)
 * @author Héctor Álvarez Ibáñez (@vodkaneitor93)
 * @author Jorge Vila Suárez (@jorgevilasuarez)
 *
 */
public class LoadUsers {
	
	public static void main(String... args) {
		ReadCensus rCensus = new RCensus();
		try {
			rCensus.readCensus(args);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
