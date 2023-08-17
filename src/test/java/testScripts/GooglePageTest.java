package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import org.testng.asserts.SoftAssert;

public class GooglePageTest {
	WebDriver driver;
	
	@BeforeMethod
	public void Initialsetup() {
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	@Test(priority=3)
  public void searchJavaTest() {
	  
		
		driver.get("https://www.google.com/");
		SoftAssert softAssert=new SoftAssert();
		AssertJUnit.assertEquals(driver.getTitle(), "Google");
		WebElement srcBox=driver.findElement(By.id("APjFqb"));
		srcBox.sendKeys("Java Tutorial");
		srcBox.sendKeys(Keys.ENTER);
		AssertJUnit.assertEquals(driver.getTitle(),"Java Tutorial - Google Search");
		softAssert.assertAll();
	}
	@Test(priority=2)
	  public void searchSeleniumTest() {
		  
			
			driver.get("https://www.google.com/");
			WebElement srcBox=driver.findElement(By.id("APjFqb"));
			srcBox.sendKeys("Selenium Tutorial");
			srcBox.sendKeys(Keys.ENTER);
			AssertJUnit.assertEquals(driver.getTitle(),"Selenium Tutorial - Google Search");
	}
	@Test(priority=1)
	  public void searchAppiumTest() {
		  
			
			driver.get("https://www.google.com/");
			WebElement srcBox=driver.findElement(By.id("APjFqb"));
			srcBox.sendKeys("Appium Tutorial");
			srcBox.sendKeys(Keys.ENTER);
			AssertJUnit.assertEquals(driver.getTitle(),"Appium Tutorial - Google Search");
	}
	@AfterMethod
	public void closedown(){
		
		driver.close(); 
	}
	}

