package seleniumbootcamp;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0782_Editcontact {
	
	@Test
	public void Editcontact() throws InterruptedException {
		
		
	WebDriverManager.chromedriver().setup();
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
		
	//1) Launch the app	
	ChromeDriver driver = new ChromeDriver(options);
	driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//2) Click Login
	driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
	//3) Login with the credentials
	driver.findElement(By.id("Login")).click();
	Thread.sleep(5000);
	//4)Click on menu button from the Left corner
	WebElement AppLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	WebDriverWait wait=new WebDriverWait(driver, 30);	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
	AppLauncher.click();
	//5) Click 'view All'
	driver.findElement(By.xpath("//button[@class='slds-button']")).click();
	//6) Click on contacts
	driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contacts");
	WebElement Contacts_Link = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark"));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='slds-truncate']/mark")));	
	Contacts_Link.click();
	//7) Get the size of contacts available and print the list
	WebElement contactsTable = driver.findElementByXPath("//table[@role='grid']/tbody");
	List<WebElement> rows = contactsTable.findElements(By.tagName("tr"));	
	System.out.println("****size of contacts*****"+rows.size());	
	for(WebElement a :rows)
		System.out.println("Contacts--->"+a.getText());
	//8) search for the contact using unique name
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
	WebElement serachTextbox = driver.findElementByXPath("//input[@placeholder='Search this list...']");
	serachTextbox.sendKeys("Shalini R");
	serachTextbox.sendKeys(Keys.ENTER);	
	Thread.sleep(5000);
	
	//9)Click on the dropdown icon available in the unique contact and select edit
	    //WebElement showAction = driver.findElementByXPath("//tbody/tr[1]/td[8]//*[local-name()='svg']");
	WebElement showAction = driver.findElementByXPath("//tbody/tr[1]/td[8]//a");
	wait.until(ExpectedConditions.visibilityOf(showAction));
	new Actions(driver).moveToElement(showAction).click().perform();
	
	//10) Edit Title as Test
	Thread.sleep(5000);
	driver.findElementByXPath("//a[@title='Edit']").click();
	driver.findElementByXPath("//input[@name='Title']").sendKeys("Test");	
    driver.findElementByXPath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']/input").click();
	
    //11) select your birthday in the birthday field
    driver.findElementByXPath("(//label[text()='Birthdate']/following::button)[1]").sendKeys("10/1/1987");
    
    //12) edit Lead Source as Purchased list
    WebElement Lead_Source = driver.findElementByXPath("(//label[text()='Lead Source']/following::button)[1]");
	Lead_Source.click();	  
	Thread.sleep(5000); 
	driver.findElementByXPath("//span[text()='Purchased List']").click();
	
    //13) Edit Phone number with personal number
	driver.findElementByXPath("//input[@name='Phone']").sendKeys("9865056602");
	
    //14) Click Save and Verify and Print Phone number
	driver.findElementByXPath("//button[text()='Save']").click();
	
	driver.close();
	 
	}

}
