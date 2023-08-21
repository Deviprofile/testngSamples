package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertTrue;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class LoginpageTest {
	WebDriver driver;
	Properties prop;
	
	@BeforeMethod
	public void setup() throws IOException {
		String path=System.getProperty("user.dir")+"//src//test//configFiles//Config.properties";
		prop=new Properties();
		FileInputStream fin=new FileInputStream(path);
		prop.load(fin);
		String strBrowser=prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}

  @Test
  public void ValidLogin() {
	  driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("Supersecretpassword");
		driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
	boolean isDisp=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		AssertJUnit.assertTrue(isDisp);
  }
  @AfterMethod
  
	  public void teardown() {
		  driver.close();
	  }
  }

