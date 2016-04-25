package es.uniovi.asw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.business.login.Authenticate;
import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Eleccion;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.persistence.dbManagement.repository.CandidacyRepository;
import es.uniovi.asw.persistence.dbManagement.repository.CircunscripcionRepository;
import es.uniovi.asw.persistence.dbManagement.repository.ConfirmedVoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.EleccionRepository;
import es.uniovi.asw.persistence.dbManagement.repository.PollingStationRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoteRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VoterRepository;
import es.uniovi.asw.persistence.dbManagement.repository.VotingRepository;
import es.uniovi.asw.view.pollingStationPresidentManagement.AddPV;
import es.uniovi.asw.view.votingSystem.voterManagement.AlreadyV;
import es.uniovi.asw.view.votingSystem.voterManagement.GetAV;
import es.uniovi.asw.view.votingSystem.voterManagement.GetVO;
import es.uniovi.asw.view.votingSystem.voterManagement.VoteV;
import es.uniovi.asw.view.systemConfiguration.administratorManagement.ConfCand;
import es.uniovi.asw.view.systemConfiguration.administratorManagement.ConfPS;
import es.uniovi.asw.view.systemConfiguration.administratorManagement.ConfVT;
import es.uniovi.asw.view.systemConfiguration.administratorManagement.GetCand;
import es.uniovi.asw.view.systemConfiguration.administratorManagement.GetPS;
import es.uniovi.asw.view.systemConfiguration.administratorManagement.GetVT;

@RestController
public class Main {

	private static final Logger LOG = LoggerFactory.getLogger(Main.class);

	@Autowired
	private VotingRepository vRep;
	@Autowired
	private CandidacyRepository cRep;
	@Autowired
	private PollingStationRepository pRep;
	@Autowired
	private CircunscripcionRepository ciRep;
	@Autowired
	private VoterRepository vtRep;
	@Autowired
	private EleccionRepository eRep;
	@Autowired
	private ConfirmedVoteRepository cvRep;
	@Autowired
	private VoteRepository voRep;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		LOG.info("Página de Login");
		model.addAttribute("voter", new Voter());
		model.addAttribute("error", null);
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView adminIndex(@ModelAttribute Voter voter, Model model, HttpSession sesion) {
		LOG.info("Panel de administración");
		Object[] resultado = Authenticate.authenticate(voter.getEmail(), voter.getPassword(), vtRep, voter);
		if (resultado[0].equals("admin")) {
			model.addAttribute("eleccion", new Eleccion());
			List<Eleccion> e = new GetVT(vRep).getActiveVotings();
			model.addAttribute("elecciones", e);
			return new ModelAndView("admin_index");
		} else if (resultado[0].equals("voter")) {
			Voter v = (Voter) resultado[1];
			sesion.setAttribute("voter", v);
			List<Eleccion> lista = new GetAV(vRep).getEleccionesActivas();
			sesion.setAttribute("eleccionesHaVotado", lista);
			return new ModelAndView("voter_index");
		} else if (resultado[0].equals("president")) {
			model.addAttribute("elecciones", new GetVT(vRep).getActiveVotings());
			return new ModelAndView("president_index");
		} else {
			model.addAttribute("error", "Usuario o contraseña incorrectos");
			return new ModelAndView("index");
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, params = "get_cand")
	public ModelAndView showVotings(Model model) {
		model.addAttribute("elecciones", new GetVT(vRep).getActiveVotings());
		return new ModelAndView("show_votings");
	}

	@RequestMapping(value = "/admin_index", method = RequestMethod.POST)
	public ModelAndView adminIndexGet(@ModelAttribute Eleccion eleccion, Model model) {
		if (eleccion.getNumeroOpciones() == null || eleccion.getNumeroOpciones().intValue() < 2) {
			model.addAttribute("error", "El número mínimo de opciones es 2");
			model.addAttribute("elecciones", new GetVT(vRep).getActiveVotings());
			return new ModelAndView("admin_index");
		}
		model.addAttribute("eleccion", eleccion);
		return new ModelAndView("new_votation");
	}

	@RequestMapping(value = "/admin_index", method = RequestMethod.POST, params = "action")
	public ModelAndView adminIndexActivate(@RequestParam(value = "action", required = true) String id, Model model) {
		model.addAttribute("eleccion", new Eleccion());
		model.addAttribute("elecciones", new GetVT(vRep).getActiveVotings());
		new ConfVT(vRep, Long.parseLong(id)).updateEleccion();
		return new ModelAndView("admin_index");
	}

	@RequestMapping(value = "/admin_index", method = RequestMethod.POST, params = "conf")
	public ModelAndView adminIndexConfOptions(@RequestParam(value = "conf", required = true) String id, Model model) {
		Eleccion e = new GetVT(vRep, cRep, Long.parseLong(id)).getById();
		e.getOpciones().remove(e.getOpciones().size() - 1);
		model.addAttribute("eleccion", e);
		return new ModelAndView("conf_options");
	}

	@RequestMapping(value = "/admin_index", method = RequestMethod.POST, params = "pollingStation")
	public ModelAndView adminIndexConfPollings(Model model) {
		model.addAttribute("colegios", new GetPS(pRep).getPollingStations());
		return new ModelAndView("list_pollings");
	}

	@RequestMapping(value = "/conf_options", method = RequestMethod.POST, params = "save_conf")
	public ModelAndView adminConfOptions(@RequestParam(value = "save_conf", required = true) String id,
			@ModelAttribute Eleccion eleccion, Model model) {
		for (Candidatura c : eleccion.getOpciones()) {
			if (c.getProgramaElectoral().trim().length() == 0 || c.getDescripcion().trim().length() == 0) {
				model.addAttribute("error",
						"Todos los campos del formulario resultan obligatorios para guardar la configuración");
				model.addAttribute("eleccion", new GetVT(vRep, cRep, Long.parseLong(id)).getById());
				return new ModelAndView("conf_options");
			}
		}
		model.addAttribute("eleccion", new Eleccion());
		new ConfCand(vRep, cRep, eleccion.getOpciones(), Long.parseLong(id)).saveCandidaturas();
		model.addAttribute("elecciones", new GetVT(vRep).getActiveVotings());
		return new ModelAndView("admin_index");
	}

	@RequestMapping(value = "/list_pollings", method = RequestMethod.POST, params = "p_params")
	public ModelAndView adminIndexConfPollings(@RequestParam(value = "p_params", required = true) String id,
			Model model) {
		model.addAttribute("colegio", new GetPS(pRep).getPollingStation(Long.parseLong(id)));
		model.addAttribute("circunscripciones", new GetPS(ciRep).getCircunscripciones());
		return new ModelAndView("conf_polling");
	}

	@RequestMapping(value = "/conf_polling", method = RequestMethod.POST)
	public ModelAndView adminIndexSavePolling(@ModelAttribute ColegioElectoral colegio, Model model) {
		if (colegio.getNombre().trim().length() == 0 || colegio.getPoblacion().trim().length() == 0) {
			model.addAttribute("colegio", new GetPS(pRep).getPollingStation(colegio.getId()));
			model.addAttribute("circunscripciones", new GetPS(ciRep).getCircunscripciones());
			model.addAttribute("error", "Existen campos obligatorios vacíos");
			return new ModelAndView("conf_polling");
		}
		new ConfPS(pRep, colegio).saveColegio();
		model.addAttribute("eleccion", new Eleccion());
		model.addAttribute("elecciones", new GetVT(vRep).getActiveVotings());
		return new ModelAndView("admin_index");
	}

	@RequestMapping(value = "/new_votation", method = RequestMethod.POST)
	public ModelAndView newVotingPost(@ModelAttribute @Valid Eleccion eleccion, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("error", "Existen campos obligatorios vacíos");
			return new ModelAndView("new_votation");
		}
		if (eleccion.getFechaInicio().after(eleccion.getFechaFin())) {
			model.addAttribute("error", "La fecha de inicio debe ser anterior a la de finalización");
			return new ModelAndView("new_votation");
		}
		for (Candidatura c : eleccion.getOpciones()) {
			if (c.getNombre().trim().length() == 0) {
				model.addAttribute("error", "Existen campos obligatorios vacíos");
				return new ModelAndView("new_votation");
			}
		}
		new ConfVT(vRep, cRep, eleccion).saveEleccion();
		model.addAttribute("elecciones", new GetVT(vRep).getActiveVotings());
		return new ModelAndView("admin_index");
	}

	@RequestMapping(value = "/show_votings", method = RequestMethod.POST, params = "get_cands")
	public ModelAndView showCandidacys(@RequestParam(value = "get_cands", required = true) String id, Model model) {
		List<Candidatura> candidaturas = new GetCand(vRep, cRep, Long.parseLong(id)).getCandidacys();
		model.addAttribute("candidaturas", candidaturas);
		return new ModelAndView("show_candidacys");
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logout() {
		return new ModelAndView("index");
	}


	// Parte de administración de voto físico
	
	@RequestMapping(value = "/president_addpv", method = RequestMethod.POST)
	public ModelAndView presidentIndexCheckVoter(
				@RequestParam(value = "voterDNI", required = true) String voterDNI,
				@RequestParam(value = "eleccionId", required = true) Long eleccionId,
				Model model) {
	
		boolean resultado = new AddPV(cvRep, vtRep, eRep).addPV(voterDNI, eleccionId);
		if (resultado) {
			model.addAttribute("mensaje", "Votante registrado");
		}
		else {
			model.addAttribute("mensaje", "El votante no se registro (dni o elección no válidas)");
		}
		model.addAttribute("elecciones", new GetVT(vRep).getActiveVotings());

		return new ModelAndView("president_index");
	}
	
	// Parte de voto remoto

		@RequestMapping(value = "/voter_index", method = RequestMethod.POST)
		public ModelAndView voterIndexVote(HttpSession sesion, @RequestParam(name = "vote", required = true) String e,
				Model model) {
			if (!new AlreadyV(cvRep).yaHaVotado(Long.parseLong(e), (Voter) sesion.getAttribute("voter"))) {
				sesion.setAttribute("opciones", new GetVO(cRep).obtenerOpciones(Long.parseLong(e)));
				return new ModelAndView("show_options");
			} else {
				model.addAttribute("error", "Error, ya ha votado en esta elección");
				return new ModelAndView("voter_index");
			}
		}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/show_options", method = RequestMethod.POST)
	public ModelAndView voterVote(HttpSession sesion,@RequestParam(name = "decision") String id, List<Candidatura> opciones, Model model) {
		for(Candidatura c : (List<Candidatura>) sesion.getAttribute("opciones")){
			if(c.getId().equals(Long.parseLong(id)))
				new VoteV(vRep,vtRep, voRep, cvRep).meterVoto(c, (Voter) sesion.getAttribute("voter"));
		}
		return new ModelAndView("voter_index");
		
	}
	

}