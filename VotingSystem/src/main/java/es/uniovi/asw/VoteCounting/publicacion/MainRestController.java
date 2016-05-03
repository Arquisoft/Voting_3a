package es.uniovi.asw.VoteCounting.publicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.VoteCounting.dto.EleccionDto;
import es.uniovi.asw.VoteCounting.dto.ResultDto;
import es.uniovi.asw.VoteCounting.recuento.CountSystem;
import es.uniovi.asw.VoteCounting.recuento.CountSystemFactory;
import es.uniovi.asw.dbManagement.Persistence;
import es.uniovi.asw.model.Eleccion;

@RestController
public class MainRestController {

	@Autowired
	CountSystemFactory countSystemFactory;
	
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
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResultDto[]> GetResultsOf(@PathVariable("id") long id) throws Exception {
		
		CountSystem countSystem = countSystemFactory.getStdCountSystem(id);
		
		if (countSystem == null) {
			new ResponseEntity<String>("{}", HttpStatus.NOT_FOUND);
		}
	
		List<ResultDto> result = new ArrayList<ResultDto>(countSystem.getVotos().size());
		for (Entry<String, Long> entry : countSystem.getVotos().entrySet()) {
			result.add(new ResultDto(entry.getKey(), entry.getValue()));
		}
		
		return  new ResponseEntity<ResultDto[]>(result.toArray(new ResultDto[0]), HttpStatus.OK);
	}
	
}
