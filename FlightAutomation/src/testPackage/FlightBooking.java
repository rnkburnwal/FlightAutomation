package testPackage;

import java.io.IOException;
import java.time.Duration;
import org.testng.annotations.Test;

public class FlightBooking extends Browser {
	
	@Test
	public void book() throws IOException, InterruptedException {
		browserActivation();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		LandingPage l = new LandingPage(driver);
		l.country(Property.getProperties("country"));
		if(Property.getProperties("roundTrip").equalsIgnoreCase("Y"))
			l.RoundTrip();
		l.departureCity(Property.getProperties("departureCity")).click();
		l.arrivalCity(Property.getProperties("arrivalCity")).click();
		l.departDate(Property.getProperties("dDate"), Property.getProperties("dMonth"));
		l.returnDate(Property.getProperties("rDate"), Property.getProperties("rMonth"));
		l.passengers(Property.getProperties("adult"),Property.getProperties("child"),Property.getProperties("infant"));
		l.currency(Property.getProperties("currency"));
		l.discountCheckBox(Property.getProperties("discountCheckBox")).click();
		if(Property.getProperties("search").equalsIgnoreCase("Y"))
			l.search().click();
	}

}
