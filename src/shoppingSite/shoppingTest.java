package shoppingSite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class shoppingTest {

	private static WebDriver webDriver;

	@BeforeAll
	public static void intitialse() {
		System.setProperty("webdriver.chrome.driver", 
				"chromedriver\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window();
		webDriver.get("http://automationpractice.com/index.php");
	}
	
	@Test
	public void search() {
		WebElement element = webDriver.findElement(By.id("search_query_top"));
		element.sendKeys("Dress");
		WebElement element1 = webDriver.findElement(By.cssSelector("#searchbox > button"));
		element1.submit();
		WebElement element2 = webDriver.findElement(By.linkText("Printed Chiffon Dress"));
		assertTrue(element2.isDisplayed());
		element2.click();
	}
	
	@AfterAll
	public static void clean() {
		try {
			Thread.sleep(5000);
			webDriver.quit();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
