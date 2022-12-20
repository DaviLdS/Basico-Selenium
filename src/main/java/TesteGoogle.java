import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public  void teste() {
//		System.setProperty("webdriver.gecko.driver","C:/Users/Davi/Downloads/Automatizado/geckodriver.exe");
//		System.setProperty("webdriver.chrome.driver","C:/Users/Davi/Downloads/Automatizado/chromedriver.exe");
//		WebDriver  driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setPosition(new Point(1000,1000));
//		driver.manage().window().setSize(new Dimension(800,600));
		driver.manage().window().maximize();
		driver.get("https://www.google.com.br/");
		Assert.assertEquals("Google",driver.getTitle());
		driver.quit();
		
	}
}
