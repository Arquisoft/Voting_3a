package es.uniovi.asw.steps;

import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import es.uniovi.asw.SeleniumUtils;

@IntegrationTest
@WebAppConfiguration
public class DespliegeSteps {
	
	private WebDriver driver = SeleniumUtils.getDriver("Configuration");
	
	@Cuando("^el cliente entra en la web$")
	public void el_cliente_entra_en_la_web() throws Throwable {
		driver.get("http://localhost:8080");
		SeleniumUtils.finishTest(driver);
	}

	@Entonces("^el cliente visualiza un mensaje de bienvenida$")
	public void el_cliente_visualiza_un_mensaje_de_bienvenida() throws Throwable {
		driver = SeleniumUtils.getDriver("Configuration");
		driver.get("http://localhost:8080");
		SeleniumUtils.esperaCargaPagina(driver, "text", "Elecciones - Sistema de resultados", 10);
		SeleniumUtils.finishTest(driver);
	}

}
