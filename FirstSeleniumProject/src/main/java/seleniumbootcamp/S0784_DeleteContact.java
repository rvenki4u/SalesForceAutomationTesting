package seleniumbootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0784_DeleteContact {

	@Test
	public void DeleteContact() throws InterruptedException {
		// TODO Auto-generated method stub

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

		//4) Click on the App Laucher Icon left to Setup
		WebElement AppLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		WebDriverWait wait=new WebDriverWait(driver, 30);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
		AppLauncher.click();

		//5) Click on View All
		WebElement ViewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button']")));
		ViewAll.click();
		
		//6) Click on Contacts
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contacts");
		WebElement Contacts = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='slds-truncate']/mark")));	
		Contacts.click();
		Thread.sleep(5000);
		
		
		//8) Get the size of conatcts available and print the list		
		List<WebElement> li = driver.findElements(By.xpath("(//table[1]/tbody/tr[1])[1]/following-sibling::tr"));
//		List<WebElement> li = driver.findElements(By.xpath("//table/tbody/tr"));
		
		int listSize = (li.size()+1);
		System.out.println("List Size--->"+listSize);
		
		
		for(int i=1;i<=li.size()+1;i++) {			
			String contact_Name = driver.findElementByXPath("//table/tbody/tr["+i+"]/th//a").getAttribute("title");			
			System.out.println("&&&&contact_Name&&&"+contact_Name);			
		}
		
		
		  //9) search for the contact using unique name
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		  "//input[@name='Contact-search-input']"))); WebElement searchTextbox =
		  driver.findElementByXPath("//input[@name='Contact-search-input']");
		  searchTextbox.sendKeys("Naveen Elumalai"); searchTextbox.sendKeys(Keys.ENTER);
		  Thread.sleep(5000);
		  
		  //10) Get the text of Contact name and store it
		  driver.findElementByXPath("//input[@placeholder='Search this list...']").
		  click();
		  
		  
		  //11) Get the text of Contact name and store it
		  WebElement showAction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[8]//a")));		 
		  driver.executeScript("arguments[0].click();", showAction);
		  driver.findElementByXPath("//a[@title='Delete']").click();
		  driver.findElementByXPath("//span[text()='Delete']").click();
		  
		  
		  //12)Verify the Deleted Contact WebElement ToastMessage =		  
		  WebElement ToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']"))); 
		  String getText = ToastMessage.getText();
		  //String value = ""\"James George\"";
		  
		  String t = "Contact \"Naveen Elumalai\" was deleted. Undo";
		  
		  System.out.println("********ActualText****************"+t);
		  System.out.println("***********getText*************"+getText);
		  Assert.assertEquals(t, getText);
		 
		  driver.close();
	}

}
