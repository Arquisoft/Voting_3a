package es.uniovi.asw.recuento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CountSystem {

	public boolean iniciar();

	public boolean terminar();
	
	public HashMap<String, Long> getResults();
	
	public String getName();
	
	public List<String> GetOptions();
	
	public void calcular();
	
	public Map<String, Long> getVotos();

	public Map<String, Map<String, Long>> getColegios();

	public Map<String, Map<String, Long>> getComunidades();
	
}
