package demoQA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class demoQATest {

	private static WebDriver webDriver;

	@BeforeAll
	public static void intitialse() {
		System.setProperty("webdriver.chrome.driver", 
				"chromedriver\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window();
		webDriver.get("http://demoqa.com/");
	}
	
	@Test
	public void registration() {
		WebElement element = webDriver.findElement(By.cssSelector("#menu-item-374 > a"));
		element.click();
		WebElement firstName = webDriver.findElement(By.id("name_3_firstname"));
		firstName.sendKeys("Emily");
		WebElement surname = webDriver.findElement(By.id("name_3_lastname"));
		surname.sendKeys("Noble");
		
		WebElement maritalStatus = webDriver.findElement(By.cssSelector("#pie_register > li:nth-child(2) > "
				+ "div > div > input:nth-child(4)"));
		maritalStatus.click();
		
		WebElement hobby1 = webDriver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[3]/div/"
				+ "div[1]/input[1]"));
		hobby1.click();
		WebElement hobby2 = webDriver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[3]"
				+ "/div/div[1]/input[2]"));
		hobby2.click();
		
		Select country = new Select(webDriver.findElement(By.xpath("//*[@id=\"dropdown_7\"]")));
		country.selectByValue("United Kingdom");
			
		Select dObMonth = new Select(webDriver.findElement(By.xpath("//*[@id=\"mm_date_8\"]")));
		dObMonth.selectByValue("10");
		
		Select dObDay = new Select(webDriver.findElement(By.xpath("//*[@id=\"dd_date_8\"]")));
		dObDay.selectByValue("10");
		
		Select dObYear = new Select(webDriver.findElement(By.xpath("//*[@id=\"yy_date_8\"]")));
		dObYear.selectByValue("1992");
		
		WebElement phoneNumber = webDriver.findElement(By.id("phone_9"));
		phoneNumber.sendKeys("0123456789");
		
		WebElement username = webDriver.findElement(By.id("username"));
		username.sendKeys("logMeIn");
		WebElement email = webDriver.findElement(By.id("email_1"));
		email.sendKeys("emily@mail.com");
		
		WebElement password1 = webDriver.findElement(By.id("password_2"));
		WebElement password2 = webDriver.findElement(By.id("confirm_password_password_2"));
		
		password1.sendKeys("password12");
		password2.sendKeys("password12");

		WebElement submit = webDriver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[14]/div/input"));
		submit.submit();
	}

}
