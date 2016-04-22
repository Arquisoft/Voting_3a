package es.uniovi.asw.steps;

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
public class EleccionesSteps {
	
	private WebDriver driver = SeleniumUtils.getDriver("Configuration");
	
	@Entonces("^va a la ventana de administrador$")
	public void va_a_la_ventana_de_administrador() throws Throwable {
		driver.get("http://localhost:8080");
		WebElement elemento2 = driver.findElement(By.id("admin"));
		Actions builder = new Actions(driver);	
		builder.moveToElement(elemento2).perform();
		elemento2.click();
	}
	
	@Entonces("^se valida con codigo de autentificacion \"([^\"]*)\" para la eleccion (\\d+)$")
	public void se_valida_con_codigo_de_autentificacion_para_la_eleccion(String arg1, int arg2) throws Throwable {
		WebElement elemento2 = driver.findElement(By.id("authCode"));
		elemento2.sendKeys(arg1);
		elemento2 = driver.findElement(By.id("idEleccion"));
		elemento2.sendKeys(arg2 + "");
	}
	
	@Entonces("^hace click en el boton de iniciar$")
	public void hace_click_en_el_boton_de_iniciar() throws Throwable {
		WebElement elemento2 = driver.findElement(By.id("iniciarRecuento"));
		elemento2.click();
	}
	
	@Entonces("^se le muestra el mensaje \"([^\"]*)\"$")
	public void se_le_muestra_el_mensaje(String arg1) throws Throwable {
		SeleniumUtils.esperaCargaPagina(driver, "text", arg1, 10);
		SeleniumUtils.finishTest(driver);
	}
	
	@Entonces("^hace click en el boton de terminar$")
	public void hace_click_en_el_boton_de_terminar() throws Throwable {
		WebElement elemento2 = driver.findElement(By.id("terminarRecuento"));
		elemento2.click();
	}
}

