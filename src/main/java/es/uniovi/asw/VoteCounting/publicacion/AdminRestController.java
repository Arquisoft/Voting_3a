package es.uniovi.asw.publicacion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uniovi.asw.recuento.CountSystem;
import es.uniovi.asw.recuento.CountSystemFactory;
import es.uniovi.asw.recuento.CountingExecutor;

@Controller
public class AdminRestController {

	// private static final Logger LOG =
	// LoggerFactory.getLogger(AdminRestController.class);

	/*
	 * @RequestMapping("/") public ModelAndView landing(Model model) { LOG.info(
	 * "Landing page access"); return new ModelAndView("landing"); }
	 */

	@RequestMapping(value = "/iniciarRecuento/{id}",
			method = RequestMethod.GET)
	public ResponseEntity<String> IniciarRecuento(@PathVariable("id") long id) throws Exception {

		System.out.println("Iniciando recuento " + id);

		CountSystem countSystem = CountSystemFactory.newStdCountSystem(id);

		CountingExecutor.register(countSystem);

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/terminarRecuento/{id}",
			method = RequestMethod.GET)
	public ResponseEntity<String> terminarRecuento(@PathVariable("id") long id) throws Exception {

		System.out.println("Recuento " + id + " terminado.");
		
		//CountSystem countSystem = CountSystemFactory.newStdCountSystem(id);

		// Hasta que se solucione problema de persistencia
		CountingExecutor.stopAll();
		//CountingExecutor.unregister(countSystem);

		return new ResponseEntity<String>(HttpStatus.OK);
	}

}