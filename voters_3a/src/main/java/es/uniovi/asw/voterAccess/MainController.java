package es.uniovi.asw.voterAccess;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.dbManagement.DBManagement;
import es.uniovi.asw.dbManagement.DBManagementVirtualImpl;
import es.uniovi.asw.model.Voter;
import es.uniovi.asw.types.ChangePass;
import es.uniovi.asw.types.UserInfo;
import es.uniovi.asw.types.UserPass;

@Controller
@RestController
public class MainController {
	
	//@Autowired
	//private VoterRepository voterRepository;

	@RequestMapping(
			value = "/user",
			method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	
	public ResponseEntity<UserInfo> GetVoterInfo(@RequestBody @Valid final UserPass userPass) throws Exception {
		
		if (userPass == null) {
			// throw new ResourceNotFoundException();
			return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
		}
		
		DBManagement db = new DBManagementVirtualImpl();
		Voter voter = db.getVoter(userPass);
		
		if (voter == null) {
			// throw new UserNotFoundException(userPass);
			return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserInfo>(new UserInfo(voter), HttpStatus.OK);
	}


	@RequestMapping(
			value = "/ChangePassword",
			method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	
	public ResponseEntity<String> ChangePassword(@RequestBody @Valid final ChangePass changePass) throws Exception {
		
		if (changePass == null) {
			// throw new ResourceNotFoundException();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		DBManagement db = new DBManagementVirtualImpl();
		Voter voter = db.getVoter(changePass.getLogin()); //changePass.getOldPassword()
		
		if (voter == null) {
			// throw new UserNotFoundException(userPass);
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		voter.setPassword(changePass.getNewPassword());
		db.save(voter);
		
		return new ResponseEntity<String>("{}",HttpStatus.OK);
	}
}
