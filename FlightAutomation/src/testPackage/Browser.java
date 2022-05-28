package testPackage;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	
	WebDriver driver;
	
	public void browserActivation() throws IOException {
		if(Property.getProperties("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.gecko.driver", "geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

}
