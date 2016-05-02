package es.uniovi.asw.VoteCounting.recuento;

import java.util.List;
import java.util.Map;

public interface CountSystem {

	void iniciar();

	void terminar();
	
	String getName();
	
	List<String> GetOptions();
	
	void calcular();
	
	Map<String, Long> getVotos();

	Map<String, Map<String, Long>> getColegios();

	Map<String, Map<String, Long>> getComunidades();
	
	Map<String, Long> getResults();

	Map<String, Long> getResultsByColegio();

	Map<String, Long> getResultsByComunidad();
	
}
