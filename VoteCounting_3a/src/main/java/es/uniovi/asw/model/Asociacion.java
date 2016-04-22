package es.uniovi.asw.model;

public class Asociacion {
	
	
	public static class ComunidadCircunscripcion {

		public static void link(ComunidadAutonoma c, Circunscripcion cir) {
			c.getCircunscripciones().add(cir);
			cir.setComunidad(c);
		}

		public static void unlink(ComunidadAutonoma c, Circunscripcion cir) {
			c.getCircunscripciones().remove(cir);
			cir.setComunidad(null);
		}
	}
	
	public static class CircunscripcionColegio {

		public static void link(Circunscripcion cir, ColegioElectoral col) {
			cir.getColegios().add(col);
			col.setCircunscripcion(cir);
		}

		public static void unlink(Circunscripcion cir, ColegioElectoral col) {
			cir.getColegios().remove(col);
			col.setCircunscripcion(null);
		}
	}
	
	public static class ColegioVoto {

		public static void link(ColegioElectoral col, Voto voto) {
			col.getVotos().add(voto);
			voto.setColegio(col);
		}

		public static void unlink(ColegioElectoral col, Voto voto) {
			col.getVotos().remove(voto);
			voto.setColegio(null);
		}
	}
	
	public static class ColegioVotante {

		public static void link(ColegioElectoral col, Voter votante) {
			col.getVotantes().add(votante);
			votante.setColegio(col);
		}

		public static void unlink(ColegioElectoral col, Voter votante) {
			col.getVotantes().remove(votante);
			votante.setColegio(null);
		}
	}
	
	public static class VotoOpcion {

		public static void link(Voto voto, Candidatura opcion) {
			opcion.getVotos().add(voto);
			voto.setOpcion(opcion);
		}

		public static void unlink(Voto voto, Candidatura opcion) {
			opcion.getVotos().remove(voto);
			voto.setOpcion(null);
		}
	}
	
	public static class EleccionOpcion {

		public static void link(Eleccion e, Candidatura o) {
			e.getOpciones().add(o);
			o.setEleccion(e);
		}

		public static void unlink(Eleccion e, Candidatura o) {
			e.getOpciones().remove(o);
			o.setEleccion(null);
		}
	}
	
	public static class EleccionVotoConfirmado {

		public static void link(Eleccion e, VotoConfirmado vc) {
			e.getVotantes().add(vc);
			vc.setEleccion(e);
		}

		public static void unlink(Eleccion e, VotoConfirmado vc) {
			e.getVotantes().remove(vc);
			vc.setEleccion(null);
		}
	}
	
	public static class VotanteVotoConfirmado {

		public static void link(Voter v, VotoConfirmado vc) {
			v.getElecciones().add(vc);
			vc.setVotante(v);
		}

		public static void unlink(Voter v, VotoConfirmado vc) {
			v.getElecciones().remove(vc);
			vc.setVotante(null);
		}
	}

}
