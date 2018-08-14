package phpTravels;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

class phpTravelTest {

	private static WebDriver webDriver;

	@BeforeAll
	public static void intitialse() {
		System.setProperty("webdriver.chrome.driver", 
				"chromedriver\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window();
		webDriver.get("https://www.phptravels.net/");
	}
	
	@Test
	public void book() throws InterruptedException {
//			Actions actions = new Actions(webDriver);
		WebElement destination = webDriver.findElement(By.cssSelector("#s2id_autogen8 > a"));
		destination.click();
		webDriver.findElement(By.cssSelector("#select2-drop > div > input")).sendKeys("london");
//		webDriver.findElement(By.cssSelector("#select2-drop > div > input")).sendKeys(Keys.RETURN);
//		webDriver.wait(2000);
//		webDriver.findElement(By.cssSelector("#select2-drop > div > input")).sendKeys(Keys.Enter);
//		actions.keyDown(Keys.RETURN).perform();
		Thread.sleep(1000);
//		webDriver.findElement(By.cssSelector("#Carousel")).click();;
		
		webDriver.findElement(By.name("checkin")).click();
		webDriver.findElement(By.name("checkin")).sendKeys("14/10/2018");
//		webDriver.findElement(By.cssSelector("#select2-drop > div > input")).sendKeys("london");
//		System.out.println(destination.isDisplayed());
//		WebElement adult = webDriver.findElement(By.cssSelector("#travellersInput"));
//		adult.sendKeys("3");
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
