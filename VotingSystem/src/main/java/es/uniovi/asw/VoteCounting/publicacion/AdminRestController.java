package es.uniovi.asw.VoteCounting.publicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uniovi.asw.VoteCounting.recuento.CountSystem;
import es.uniovi.asw.VoteCounting.recuento.CountSystemFactory;
import es.uniovi.asw.VoteCounting.recuento.impl.CountingExecutor;

@Controller
public class AdminRestController {

	@Autowired
	CountingExecutor countingExecutor;
	
	@Autowired
	CountSystemFactory countSystemFactory;

	@RequestMapping(value = "/iniciarRecuento/{id}",
			method = RequestMethod.GET)
	public ResponseEntity<String> IniciarRecuento(@PathVariable("id") long id) throws Exception {

		System.out.println("Iniciando recuento " + id);

		CountSystem countSystem = countSystemFactory.getStdCountSystem(id);

		countingExecutor.register(countSystem);

		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/terminarRecuento/{id}",
			method = RequestMethod.GET)
	public ResponseEntity<String> terminarRecuento(@PathVariable("id") long id) throws Exception {

		System.out.println("Recuento " + id + " terminado.");
		
		CountSystem countSystem = countSystemFactory.getStdCountSystem(id);

		//countingExecutor.stopAll();
		countingExecutor.unregister(countSystem);

		return new ResponseEntity<String>(HttpStatus.OK);
	}

}