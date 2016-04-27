package es.uniovi.asw.VoteCounting.recuento;

public class CountSystemFactory {

	public static CountSystem newStdCountSystem(long id) {
		return new StdCountSystem(id);
	}
}
