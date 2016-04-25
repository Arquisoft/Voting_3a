package es.uniovi.asw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import es.uniovi.asw.model.types.VotoConfirmadokey;


@IdClass(VotoConfirmadokey.class)
@Entity
public class VotoConfirmado {
	
	@Id @GeneratedValue
	private Long id;
	
	@Id @ManyToOne private Voter votante;
	@Id @ManyToOne private Eleccion eleccion;
	private boolean haVotado;
	
	VotoConfirmado() {}
	
	public VotoConfirmado(Voter voter, Eleccion eleccion){
		Asociacion.EleccionVotoConfirmado.link(eleccion, this);
		Asociacion.VotanteVotoConfirmado.link(voter, this);
	}
	
	public Voter getVotante() {
		return votante;
	}
	public void setVotante(Voter votante) {
		this.votante = votante;
	}
	public Eleccion getEleccion() {
		return eleccion;
	}
	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}
	public boolean isHaVotado() {
		return haVotado;
	}
	public void setHaVotado(boolean haVotado) {
		this.haVotado = haVotado;
	}
	
	@Override
	public String toString() {
		return "VotoConfirmado [votante=" + votante + ", eleccion=" + eleccion + ", haVotado=" + haVotado + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eleccion == null) ? 0 : eleccion.hashCode());
		result = prime * result + ((votante == null) ? 0 : votante.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VotoConfirmado other = (VotoConfirmado) obj;
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
