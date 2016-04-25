/**
 * 
 */
package es.uniovi.asw.model.types;

/**
 * @author Amir H. Tofigh Halati
 *
 */
public class UserPassInitStop {
	
		private String usuario, contraseña;
		private Long id;

		/**
		 * @param usuario
		 * @param contraseña
		 * @param id
		 */
		public UserPassInitStop(String usuario, String contraseña, Long id) {
			this.usuario = usuario;
			this.contraseña = contraseña;
			this.id = id;
		}
		
		/**
		 * @return the contraseña
		 */
		public String getContraseña() {
			return contraseña;
		}
		/**
		 * @param contraseña the contraseña to set
		 */
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}
		/**
		 * @return the usuario
		 */
		public String getUsuario() {
			return usuario;
		}
		/**
		 * @param usuario the usuario to set
		 */
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

}
