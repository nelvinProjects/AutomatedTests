package demoSite;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.lang.model.element.ExecutableElement;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

class demoSiteTest {

	private static WebDriver webDriver;
	private static ExtentReports extent;
	private static ExtentTest test;
	private static XSSFSheet sheet;

	@BeforeAll
	public static void intitialse() {
		System.setProperty("webdriver.chrome.driver", 
				"chromedriver\\chromedriver.exe");
		webDriver = new ChromeDriver();
		extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\JavaProjects\\AutomatedTests\\auto.html", true);
		webDriver.manage().window();
		webDriver.get("http://thedemosite.co.uk/");
		test = extent.startTest("Demo Site");
		test.log(LogStatus.INFO, "Browser opened");
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Desktop\\JavaProjects\\AutomatedTests\\src\\demoSite\\demoLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
		}catch (IOException e) {
			 e.printStackTrace();
		}catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	@Test
	public void clicklink() {
		WebElement element = webDriver.findElement(By.linkText("3. Add a User"));
		assertTrue(element.isDisplayed());
		element.click();
		test.log(LogStatus.PASS, "Element clicked and displayed");
	}
	
	@Test
	public void createAccount() {
		WebElement element2 = webDriver.findElement(By.name("username"));
		WebElement element3 = webDriver.findElement(By.name("password"));
		WebElement element4 = webDriver.findElement(By.name("FormsButton2"));
		XSSFCell usercell = sheet.getRow(1).getCell(0);
		XSSFCell userpass = sheet.getRow(1).getCell(1);
//		System.out.println(usercell.toString() + userpass.toString());
		element2.sendKeys(usercell.toString());
		element3.sendKeys(userpass.toString());
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
		assertEquals("**Successful Login**", element9.getText());
		test.log(LogStatus.PASS, "Login successful");
	}
	
	@AfterAll
	public static void clean() {
		try {
			Thread.sleep(5000);
			webDriver.quit();
			extent.flush();		
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
