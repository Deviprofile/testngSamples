package testScripts;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v113.network.Network;
import org.openqa.selenium.devtools.v114.emulation.Emulation;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;
	@BeforeTest
	public void setup() {
		driver=new ChromeDriver();
		devTools=driver.getDevTools();
		devTools.createSession();
	}
	
  @Test
  public void viewPortTest() {
	  Map deviceMetrics= new HashMap() {{
	  put("width",400);
	  put("height",800);
	  put("deviceScaleFactor",50);
	  put("mobile",true);
	  }}; 
	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMetrics);
	  
	  driver.get("https://www.Selenium.dev/");
  }
	@Test
	 public void getNetworkTrafficDet() {
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(),
				entry ->{
			System.out.println("Request URL:"+entry.getRequest().getUrl()+"\n"
					+"With method :"+entry.getRequest().getMethod()+"\n");
			entry.getRequest().getMethod();
		});
		driver.get("https://www.google.com");
		devTools.send(Network.disable());
	}
	@Test
	 public void geoLocTest() {
		devTools.send(Emulation.setGeolocationOverride(
				Optional.of(27.664827),
				Optional.of(-81.515755),
				Optional.of(100))
				);
		driver.get("https://oldnavy.gap.com/stores");
	}
	@Test
	
	public void basicAuthTest() {
		
	}
}


