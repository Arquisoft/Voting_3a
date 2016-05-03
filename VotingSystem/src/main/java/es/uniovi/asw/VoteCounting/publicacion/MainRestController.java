package es.uniovi.asw.VoteCounting.publicacion;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.VoteCounting.dto.EleccionDto;
import es.uniovi.asw.dbManagement.Persistence;
import es.uniovi.asw.model.Eleccion;

@RestController
public class MainRestController {

	@RequestMapping(value = "/elecciones",
			method = RequestMethod.GET,
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<EleccionDto[]> GetListOfElecciones() throws Exception {
		
		ArrayList<EleccionDto> array = new ArrayList<EleccionDto>();
		for (Eleccion eleccion : Persistence.voting.findAll()) {
			array.add(new EleccionDto(eleccion));
		}
		
		System.out.println("/elecciones (" + array.size() + ")");
		
		return  new ResponseEntity<EleccionDto[]>(array.toArray(new EleccionDto[0]), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/eleccion/{id}",
			method = RequestMethod.GET,
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> GetResultsOf(@PathVariable("id") long id) throws Exception {

		Eleccion eleccion = Persistence.voting.findOne(id);
		
		if (eleccion == null) {
			new ResponseEntity<String>("{}", HttpStatus.NOT_FOUND);
		}
	
		return  new ResponseEntity<Eleccion>(eleccion, HttpStatus.OK);
	}
	
}
