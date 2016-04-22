package es.uniovi.asw;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.uniovi.asw.model.Candidatura;
import es.uniovi.asw.model.Voter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class MainControllerTest {

  @Autowired
  private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testLanding() throws Exception {
    mvc.perform(get("/")).andExpect(status().isOk()).andExpect(content().string(containsString("Log-in")));
  }
  
  @Test
  public void adminIndexGet() throws Exception {
    mvc.perform(post("/admin_index")).andExpect(status().isOk()).andExpect(content().string(containsString("elecciones")));
  }
  
  @Test
  public void showVotings() throws Exception {
	  mvc.perform(post("/").param("get_cand", "")).andExpect(status().isOk()).andExpect(content().string(containsString("elecciones")));
  }
  
  @Test
  public void adminIndexActivate() throws Exception {
	  mvc.perform(post("/admin_index").param("action", "1")).andExpect(status().isOk()).andExpect(content().string(containsString("Panel de")));
  }
  
  @Test
  public void adminIndexConfOptions() throws Exception {
	  mvc.perform(post("/admin_index").param("conf", "1")).andExpect(status().isOk()).andExpect(content().string(containsString("de candidaturas")));
  }
  
  @Test
  public void adminIndexConfPollings() throws Exception {
	  mvc.perform(post("/admin_index").param("pollingStation", "")).andExpect(status().isOk()).andExpect(content().string(containsString("de configuración de colegios")));
  }
  
  @Test
  public void voterIndex() throws Exception {
	  mvc.perform(post("/voter_index").session(new MockHttpSession()).sessionAttr("voter", new Voter("Prueba", "a@b.c","abc","0000000002")).param("vote" , "1")).andExpect(status().isOk()).andExpect(content().string(containsString("Opciones")));
  }
  
  @Test
  public void voterVote() throws Exception {
	  mvc.perform(post("/show_options").session(new MockHttpSession()).sessionAttr("voter", new Voter("Prueba", "a@b.c","abc","0000000002")).sessionAttr("opciones", new ArrayList<Candidatura>()).param("decision" , "1")).andExpect(status().isOk()).andExpect(content().string(containsString("Sistema de votación")));
  }
}