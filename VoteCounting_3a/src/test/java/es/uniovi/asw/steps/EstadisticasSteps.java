package es.uniovi.asw.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.es.Entonces;
import es.uniovi.asw.SeleniumUtils;

@IntegrationTest
@WebAppConfiguration
public class EstadisticasSteps {
	
	private WebDriver driver = SeleniumUtils.getDriver("Configuration");
	
	@Entonces("^el hace click en consultar lista de eleccion$")
	public void el_hace_click_en_consultar_lista_de_eleccion() throws Throwable {
		driver.get("http://localhost:8080");
		WebElement elemento2 = driver.findElement(By.id("listaE"));
		Actions builder = new Actions(driver);	
		builder.moveToElement(elemento2).perform();
		elemento2.click();
	}

	@Entonces("^hace click en la primera eleccion$")
	public void hace_click_en_la_primera_eleccion() throws Throwable {
		List<WebElement> elementos = SeleniumUtils.esperaCargaPagina(driver, "class", "list-group", 2);
		elementos.get(1).click();
	}

	@Entonces("^ve \"([^\"]*)\"$")
	public void ve(String arg1) throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", arg1, 10);
		SeleniumUtils.finishTest(driver);
	}
}

