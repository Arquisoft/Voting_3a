package es.uniovi.asw.model.types;

import java.io.Serializable;

public class VotoConfirmadokey implements Serializable{

	private static final long serialVersionUID = 1L;
	Long votante;
	Long eleccion;
	
	public VotoConfirmadokey  () {}
	

	public Long getVotante() {
		return votante;
	}

	public void setVotante(Long votante) {
		this.votante = votante;
	}

	public Long getEleccion() {
		return eleccion;
	}

	public void setEleccion(Long eleccion) {
		this.eleccion = eleccion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eleccion == null) ? 0 : eleccion.hashCode());
		result = prime * result + ((votante == null) ? 0 : votante.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VotoConfirmadokey other = (VotoConfirmadokey) obj;
		if (eleccion == null) {
			if (other.eleccion != null)
				return false;
		} else if (!eleccion.equals(other.eleccion))
			return false;
		if (votante == null) {
			if (other.votante != null)
				return false;
		} else if (!votante.equals(other.votante))
			return false;
		return true;
	}
	
	

}
