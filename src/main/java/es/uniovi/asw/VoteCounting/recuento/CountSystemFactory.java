package es.uniovi.asw.recuento;

public class CountSystemFactory {

	public static CountSystem newStdCountSystem(long id) {
		return new StdCountSystem(id);
	}
}
