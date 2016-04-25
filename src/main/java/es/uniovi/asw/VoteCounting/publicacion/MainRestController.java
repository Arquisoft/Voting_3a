package es.uniovi.asw.publicacion;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.persistence.Repository;

@RestController
public class MainRestController {

	@RequestMapping(value = "/elecciones",
			method = RequestMethod.GET,
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Eleccion[]> GetListOfElecciones() throws Exception {
		
		Iterable<Eleccion> elecciones = Repository.eleccionRep.findAll();
		ArrayList<Eleccion> array = new ArrayList<Eleccion>();
		for (Eleccion eleccion : elecciones) {
			array.add(eleccion);
		}
		
		// Temporal hasta que aya datos
		Eleccion e1 = new Eleccion();
		e1.setNombre("Elecciones Generales España 2016");

		Eleccion e2 = new Eleccion();
		e2.setNombre("Elecciones Municipales 2015");
		
		Eleccion e3 = new Eleccion();
		e3.setNombre("Elecciones Autonómicas 2014");
		
		array.add(e1);
		array.add(e2);
		array.add(e3);
		
		System.out.println("/elecciones (" + array.size() + ")");
		
		return  new ResponseEntity<Eleccion[]>(array.toArray(new Eleccion[1]), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/eleccion/{id}",
			method = RequestMethod.GET,
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> GetResultsOf(@PathVariable("id") long id) throws Exception {

		Eleccion eleccion = Repository.eleccionRep.findById(id);
		
		if (eleccion == null) {
			//new ResponseEntity<String>("{}", HttpStatus.NOT_FOUND);
			
			// temporal
			eleccion = new Eleccion();
			
		}
	
		return  new ResponseEntity<Eleccion>(eleccion, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/test",
			method = RequestMethod.GET)
	public ResponseEntity<String> test() throws Exception {
		System.out.println("/test");
		return  new ResponseEntity<String>("{}", HttpStatus.OK);
	}
}
