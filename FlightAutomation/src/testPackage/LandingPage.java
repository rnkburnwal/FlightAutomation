package testPackage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void country(String country) throws InterruptedException {
		driver.findElement(By.id("autosuggest")).sendKeys(country);
		Thread.sleep(2000);
		List<WebElement> a = driver.findElements(By.cssSelector("a[class='ui-corner-all']"));
		a.stream().filter(s->s.getText().equalsIgnoreCase(country)).forEach(s->s.click());
	}
	
	public WebElement departureCity(String city) {
		driver.findElement(By.cssSelector("input[id*='originStation1']")).click();
		return driver.findElement(By.cssSelector("a[value='"+ city +"']"));
	}
	
	public WebElement arrivalCity(String city) {
		return driver.findElement(By.cssSelector("div[id*='destinationStation1'] a[value='"+ city +"']"));
	}
	
	public void RoundTrip() {
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	}
	
	public void departDate(String dateGiven, String monthGiven) {
		dateSelection(dateGiven,monthGiven);
	}
	
	public void returnDate(String dateGiven, String monthGiven) {
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		dateSelection(dateGiven,monthGiven);
	}
	
	public void dateSelection(String dateGiven, String monthGiven) {
		List<WebElement> month;
		while(true)
		{
			month = driver.findElements(By.cssSelector("span[class='ui-datepicker-month']"));
			if(month.get(0).getText().equalsIgnoreCase(monthGiven) || month.get(1).getText().equalsIgnoreCase(monthGiven)) {
				break;
			}
			else {
				driver.findElement(By.cssSelector("a[data-handler='next']")).click();
			}
		}
		List<WebElement> date = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		if(month.get(0).getText().equalsIgnoreCase(monthGiven))
		{
			for(int i=0;i<date.size();i++)
			{
				if(date.get(i).getText().equals(dateGiven))
				{
					date.get(i).click();
					break;
				}
			}
		}
		else {
			for(int i=date.size()-1;i>=0;i--) {
				if(date.get(i).getText().equals(dateGiven))
				{
					date.get(i).click();
					break;
				}
			}
		}
	}
	
	public void passengers(String adult1, String child1, String infant1) {
		
		int adult = Integer.parseInt(adult1);
		int child = Integer.parseInt(child1); 
		int infant = Integer.parseInt(infant1);
		driver.findElement(By.id("divpaxinfo")).click();
		if(adult>9 || (adult+child)>9 || child>4 || infant>4)
		{
			System.out.println("Sorry too many people\n"
					+ "1. Maximum 4 infant allowed\n"
					+ "2. Maximum 4 child allowed\n"
					+ "3. Maximum 9 Adult Allowed\n"
					+ "4. Adult + Child <= 9");
		}
		else {
			for(int i=1;i<adult;i++)
			{
				driver.findElement(By.id("hrefIncAdt")).click();
			}
			for(int i=0;i<child;i++)
			{
				driver.findElement(By.id("hrefIncChd")).click();
			}
			for(int i=0;i<infant;i++)
			{
				driver.findElement(By.id("hrefIncInf")).click();
			}
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
	}
	
	public void currency(String currency) {
		Select a = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		a.selectByVisibleText(currency);
	}
	
	public WebElement discountCheckBox(String Category) {
		if(Category.equalsIgnoreCase("Family and Friends"))
			return driver.findElement(By.cssSelector("input[id*='friendsandfamily']"));
		if(Category.equalsIgnoreCase("Senior Citizen"))
			return driver.findElement(By.cssSelector("input[id*='SeniorCitizen']"));
		if(Category.equalsIgnoreCase("Indian Armed Forces"))
			return driver.findElement(By.cssSelector("input[id*='IndArm']"));
		if(Category.equalsIgnoreCase("Student"))
			return driver.findElement(By.cssSelector("input[id*='Student']"));
			return driver.findElement(By.cssSelector("input[id*='Unmr']"));
	}
	
	public WebElement search() {
		return driver.findElement(By.cssSelector("input[value='Search']"));
	}

}
