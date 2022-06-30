package seleniumbootcamp;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead_Xpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		driver.findElementByXPath("//input[@name='USERNAME']").sendKeys("demosalesmanager");
		driver.findElementByXPath("//input[@name='PASSWORD']").sendKeys("crmsfa");
		
		driver.findElementByXPath("//input[@type='submit']").click();
		
		driver.findElementByXPath("//div[@for='crmsfa']/a").click();
		
		driver.findElementByXPath("//a[text()='Create Lead']").click();
		
		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys("Shalom");
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys("Robin");
		
		driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys("Uthappa");
		
		driver.findElementByXPath("//input[@value='Create Lead']").click();
		
		
		

	}

}
