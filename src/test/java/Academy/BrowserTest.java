package Academy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	@Test
	public void getData() {
		System.out.println("Hello Guys");
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1920,1080");

		WebDriver driver = new ChromeDriver(options);
		try {
			driver.get("https://nishkapasi-fjfjckekc7d7g9dx.westus3-01.azurewebsites.net/webapp/");
			String text = driver.findElement(By.cssSelector("h1")).getText();
			System.out.println(text);
			Assert.assertTrue(text.equalsIgnoreCase("NishKapasi.com"));
		} finally {
			driver.quit();
		}
	}
}
