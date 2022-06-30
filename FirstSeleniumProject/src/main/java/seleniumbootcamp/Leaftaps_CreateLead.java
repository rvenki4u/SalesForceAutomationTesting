package seleniumbootcamp;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leaftaps_CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		
		Select s = new Select(driver.findElementById("createLeadForm_dataSourceId"));
		List<WebElement> li = s.getOptions();
		
		int size = li.size();
		System.out.println("******size****"+size);
		s.selectByIndex(size-2);
		
		Select se = new Select(driver.findElementById("createLeadForm_marketingCampaignId"));
		List<WebElement> la = se.getOptions();		
		int la_size = la.size();
		System.out.println("******size****"+la_size);		 
		se.selectByIndex(2);
		
		/*
		 * driver.findElementById("createLeadForm_companyName").
		 * sendKeys("Shalom Technologies P Ltd.,");
		 * driver.findElementById("createLeadForm_firstName").sendKeys("Venkata");
		 * driver.findElementById("createLeadForm_lastName").sendKeys("R");
		 * 
		 * 
		 * WebElement source = driver.findElementById("createLeadForm_dataSourceId");
		 * Select dropdown = new Select(source);
		 * dropdown.selectByVisibleText("Employee");
		 * 
		 * driver.findElementByName("submitButton").click();
		 */
        
		
		
	}

}
