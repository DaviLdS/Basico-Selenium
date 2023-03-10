import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		WebDriver  driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100,100));
		driver.manage().window().setSize(new Dimension(800,600));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste 1");
		Assert.assertEquals("Teste 1",driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));	
		driver.quit();
	}
	
	@Test
	public void deveInteragirComTextArea() {
		WebDriver  driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100,100));
		driver.manage().window().setSize(new Dimension(800,600));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste 2");
		Assert.assertEquals("Teste 2",driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		WebDriver  driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100,100));
		driver.manage().window().setSize(new Dimension(800,600));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComCheckBox() {
		WebDriver  driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100,100));
		driver.manage().window().setSize(new Dimension(800,600));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveInteragirComCombo() {
		WebDriver  driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100,100));
		driver.manage().window().setSize(new Dimension(800,600));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
//		combo.selectByIndex(2);
//		combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		Assert.assertEquals("2o grau completo",combo.getFirstSelectedOption().getText());
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresCombo() {
		WebDriver  driver = new FirefoxDriver();
		driver.manage().window().setPosition(new Point(100,100));
		driver.manage().window().setSize(new Dimension(800,600));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8,options.size());
		boolean encontrou = false;
		for (WebElement option: options) {
			if(option.getText().equals("Doutorado")){
				encontrou = true;
				break;
				}
		}
		Assert.assertTrue(encontrou);
		driver.quit();
	}
	
}
