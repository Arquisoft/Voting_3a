package voterAccess;


import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import es.uniovi.asw.Application;




@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class MainControllerTest {

	@Value("${local.server.port}")
	private int port;
	@Autowired WebApplicationContext wac;
	private URL base;
	private RestTemplate template;
	private MockMvc mvc;
	boolean porPantalla=false;




	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws Exception {
		this.base = new URL("http://localhost:" + port + "/");
		template = new TestRestTemplate();		
		mvc = new MockMvcBuilders().webAppContextSetup(wac).build();

	}

	/*
	@Test
	public void getUser() throws Exception {
		String userURI = base.toString() + "/user";

		UserInfo expected = new UserInfo("David", "1234546789J", "uo212486", "123A");
		UserPass requestData = new UserPass("uo212486", "password");

		// retorna error 406. Puede que falte el accept aplication/json, no se.
		ResponseEntity<UserInfo> response = template.postForEntity(userURI, requestData, UserInfo.class);

		assertThat(response.getStatusCode(), equalTo(Status.OK));
		assertThat(response.getBody(), equalTo(expected));
	}*/

	/*
	 * 
	 * 
	 * BLOQUE DE TESTS DEDICADOS AL: Peticion, respuesta  y Json. 
	 * 
	 * 
	 */

	@Test
	public void getLanding() throws Exception {
		//String userURI = base.toString() + "/user";
		ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
		assertThat(response.hasBody(), equalTo(true));
		if (porPantalla) { System.out.println(response.getBody()); }
	}

	@Test	
	public void printScreen() throws Exception {
		MvcResult m = (mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)

				.content("{\"login\":\"user1@mail.com\", \"password\": \"user1\"}")
				).andReturn());

		if (porPantalla){ 
			System.out.println("RESULTADO JSON OBTENIDO: "+ m.getResponse().getContentAsString());
		}
	}

	@Test
	public void postUserOK() throws Exception {
		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user2@mail.com\", \"password\": \"user2\"}"))
		.andExpect(status().isOk());
	}

	@Test
	public void postUserKnown() throws Exception {
		//Voter vo = new Voter(nombre, email, password, nif, pollingStationCode)
		//Voter voter1 = new Voter("User1", "user1@mail.com", "user1", "12312321Q", 123);
		
		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user2@mail.com\", \"password\": \"user2\"}")
				).andExpect(status().isOk())
		.andExpect(jsonPath("name", equalTo("User2")));
	}

	@Test
	public void postUserUNknown() throws Exception {		
		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"emailnovalido666@mail.com\", \"password\": \"password\"}")
				).andExpect(status().isNotFound());
	}

	@Test
	public void postUserBadPass() throws Exception {		
		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user1@mail.com\", \"password\": \"pas\"}")
				).andExpect(status().isNotFound());		 
	}

	@Test
	public void postUserInvalidMailFormat_at() throws Exception {		
		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user1mail.com\", \"password\": \"user1\"}")
				).andExpect(status().isNotFound());		 	
	}

	@Test
	public void postUserInvalidMailFormat_domain() throws Exception {		
		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user1@gmail.com\", \"password\": \"user1\"}")
				).andExpect(status().isNotFound());			
	}

	@Test
	public void postUserInvalidMailFormatDomain_wrongPass() throws Exception {		
		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user1@mail.com\", \"password\": \"pa\"}")
				).andExpect(status().isNotFound());		
	}

	// COMPROBACION DE CAMBIO DE PASS 
	@Test
	public void postUserChangePass() throws Exception {		
		//cambia pass
		mvc.perform(post("/ChangePassword")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user1@mail.com\", \"oldPassword\": \"user1\", \"newPassword\": \"newPass\"}")
				).andExpect(status().isOk());		

		//comprueba pass nueva
		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user1@mail.com\", \"password\": \"newPass\"}")
				).andExpect(status().isOk())
		.andExpect(jsonPath("name", equalTo("User1")));
		//.andExpect(jsonPath("pollingStationCode", equalTo("123")));
	}

	@Test
	public void postUserChangePassErrorUser() throws Exception {		
	
		mvc.perform(post("/ChangePassword")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user1@mail.com\", \"oldPassword\": \"user1\", \"newPassword\": \"newPass\"}"))
			.andExpect(status().isOk());		

		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("null"))
			.andExpect(status().is4xxClientError());
	}

	@Test
	public void postUserChangePassErrorChangePass() throws Exception {		
	
		mvc.perform(post("/ChangePassword")
				.contentType(MediaType.APPLICATION_JSON)
				.content("null")
				).andExpect(status().is4xxClientError());	

		
		mvc.perform(post("/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"login\":\"user1@mail.com\", \"password\": \"newPass\"}")
				).andExpect(status().isOk())
		.andExpect(jsonPath("name", equalTo("User1")));
	
	}


	

}