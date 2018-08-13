package demoSite;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class demoSiteTest {

	private static WebDriver webDriver;

	@BeforeAll
	public static void intitialse() {
		System.setProperty("webdriver.chrome.driver", 
				"chromedriver\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window();
		webDriver.get("http://thedemosite.co.uk/");
	}
	
	@Test
	public void clicklink() {
		WebElement element = webDriver.findElement(By.linkText("3. Add a User"));
		assertTrue(element.isDisplayed());
		element.click();
	}
	
	@Test
	public void createAccount() {
		WebElement element2 = webDriver.findElement(By.name("username"));
		WebElement element3 = webDriver.findElement(By.name("password"));
		WebElement element4 = webDriver.findElement(By.name("FormsButton2"));
		element2.sendKeys("qauser");
		element3.sendKeys("password");
		element4.submit();
		WebElement element5 = webDriver.findElement(By.linkText("4. Login"));
		element5.click();
		login();
	}
	
	public void login() {
		WebElement element6 = webDriver.findElement(By.name("username"));
		WebElement element7 = webDriver.findElement(By.name("password"));
		WebElement element8 = webDriver.findElement(By.name("FormsButton2"));
		element6.sendKeys("qauser");
		element7.sendKeys("password");
		element8.submit();
		WebElement element9 = webDriver.findElement(By.cssSelector("body > table > tbody > tr >"
				+ " td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		System.out.println(element9.getText());
		assertEquals("Login test","**Successful Login**", element9.getText());
	}
	
	@AfterAll
	public static void clean() {
		Timer timer = new Timer();
		try {
			timer.wait(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		webDriver.close();
	}

}
