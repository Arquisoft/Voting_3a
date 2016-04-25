package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Voto {
	
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	private ColegioElectoral colegio;
	
	@ManyToOne
	private Candidatura opcion;
	
	Voto() {}

	public Voto(ColegioElectoral colegio){
		Asociacion.ColegioVoto.link(colegio, this);
	}
	
	public Voto(Candidatura opcion){
		Asociacion.VotoOpcion.link(this, opcion);
	}
	
	public ColegioElectoral getColegio() {
		return colegio;
	}

	public void setColegio(ColegioElectoral colegio) {
		this.colegio = colegio;
	}

	public Candidatura getOpcion() {
		return opcion;
	}

	public void setOpcion(Candidatura opcion) {
		this.opcion = opcion;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colegio == null) ? 0 : colegio.hashCode());
		result = prime * result + ((opcion == null) ? 0 : opcion.hashCode());
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
		Voto other = (Voto) obj;
		if (colegio == null) {
			if (other.colegio != null)
				return false;
		} else if (!colegio.equals(other.colegio))
			return false;
		if (opcion == null) {
			if (other.opcion != null)
				return false;
		} else if (!opcion.equals(other.opcion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", colegio=" + colegio + ", opcion=" + opcion + "]";
	}

}
