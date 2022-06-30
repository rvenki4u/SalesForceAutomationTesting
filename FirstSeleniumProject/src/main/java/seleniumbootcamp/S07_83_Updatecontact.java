package seleniumbootcamp;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_83_Updatecontact {

	public static void main(String[] args) throws InterruptedException {


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
		WebDriverWait wait=new WebDriverWait(driver, 40);	
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
		serachTextbox.sendKeys("Naveen Elumalai");
		serachTextbox.sendKeys(Keys.ENTER);	
		Thread.sleep(5000);
		
		//9)Click on the dropdown icon available in the unique contact and select edit	
		//	WebElement showAction = driver.findElementByXPath("//tbody/tr[1]/td[8]//*[local-name()='svg']");
		WebElement showAction = driver.findElementByXPath("//tbody/tr[1]/td[8]//a");
		wait.until(ExpectedConditions.visibilityOf(showAction));
		new Actions(driver).moveToElement(showAction).click().perform(); 

		//10) Click on the dropdown icon available in the unique contact and select edit 
		driver.findElementByXPath("//a[@title='Edit']").click();

		/*
		 * WebDriverWait wait4 = new WebDriverWait(driver,20); WebElement editLink =
		 * driver.findElementByXPath("//a[@title='Edit']");
		 * wait4.until(ExpectedConditions.visibilityOf(editLink)); editLink.click();
		 */	
		//driver.findElementByXPath("//a[@title='Edit']").click();

		//10)Update Email with your personal mail id WebElement email_Textbox =
		WebElement email_Textbox =driver.findElementByXPath("//input[@name='Email']"); 
		email_Textbox.clear();
		email_Textbox.sendKeys("venki@gmail.com");
		
		//11)Update Lead Source as Partner Referral from bottom
		WebElement Lead_Source = driver.findElementByXPath("(//label[text()='Lead Source']/following::button)[1]");
		Lead_Source.click();
		WebElement partner_Referral = driver.findElementByXPath("//span[text()='Partner Referral']");
		wait.until(ExpectedConditions.visibilityOf(partner_Referral));
		partner_Referral.click();
		 
		
		/*
		 * WebElement partner_Referral =
		 * driver.findElementByXPath("//span[text()='Partner Referral']"); WebDriverWait
		 * wait4 = new WebDriverWait(driver,20);
		 * wait4.until(ExpectedConditions.elementToBeClickable(partner_Referral));
		 * partner_Referral.click();
		 */	 
		//12) Update MailingAddress with personal address
		//driver.findElementByXPath("(//textarea[@name='street'])[1]")
		driver.findElementByXPath("(//textarea[@name='street'])[1]").sendKeys("12th Market Street,Sydney,Australia");

		//13)Update Level as Tertiary 
		
		  WebElement Level = driver.findElementByXPath("(//label[text()='Level']/following::button)[1]");
		  driver.executeScript("arguments[0].click();", Level);
		  //Level.click(); 
		  Thread.sleep(5000);		  
		  driver.findElementByXPath("//span[text()='Tertiary']").click();
		 
		 
		
		  WebElement tertiary_Option = driver.findElementByXPath("//span[text()='Tertiary']");
		  wait.until(ExpectedConditions.visibilityOf(tertiary_Option));
		  tertiary_Option.click();
		 

		//14)Update title as Automation Testing
		driver.findElementByXPath("//input[@name='Title']").clear();
		driver.findElementByXPath("//input[@name='Title']").sendKeys("Automation Testing");

		//15) Click Save and Verify and print Email
		driver.findElementByXPath("//button[text()='Save']").click();

		//16)Verify and print Email
		WebElement ToastMessage = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']")));
		String getText = ToastMessage.getText();
		String value = "\"Mr. Naveen Elumalai\"";
		

		String ActualText = "Contact " + value + " was saved.";
		System.out.println("********ActualText****************"+ActualText);
		System.out.println("***********getText*************"+getText);
		if(getText.contains(ActualText)) {		
			System.out.println("True");
		}
		Assert.assertEquals(ActualText, getText);

		
	}

}
