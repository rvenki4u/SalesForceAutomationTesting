package seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_78_EditServiceTerritories {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		
		//6) Click on Service Territories
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service Territories");
		WebElement Service_Territories = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='slds-truncate']/mark")));	
		Service_Territories.click();
		
		//7) Click on Down Arrow DropDown and choose edit
		WebElement showAction = driver.findElementByXPath("//tbody/tr[1]/td[8]//a");
		wait.until(ExpectedConditions.visibilityOf(showAction));
		driver.executeScript("arguments[0].click();", showAction);
		driver.findElementByXPath("//a[@title='Edit']").click();		
		
		//8) Get the System Information Created by Using Regex print the name alone
		String created_By = driver.findElementByXPath("(//div[@class='slds-form-element__control slds-grid itemBody'])[2]/span").getText();
		String[] split_created_Owner = created_By.split(",");
		System.out.println("created_Owner------->"+split_created_Owner[0]);
		
		
		//9) Get the System Information Modified By Using Regex print the name alone
		String modified_By = driver.findElementByXPath("(//div[@class='slds-form-element__control slds-grid itemBody'])[2]/span").getText();
		String[] modified_By_Owner = modified_By.split(",");
		System.out.println("********modified_By_Owner***"+modified_By_Owner[0]);
			
		
		//10) Get the text of the owner 
		String last_Modified = driver.findElementByXPath("(//div[@class='slds-form-element__control slds-grid itemBody'])[3]/span").getText();
		String[] last_Modified_Owner = last_Modified.split(",");		
		//System.out.println("********last_Modified_By***"+last_Modified_Owner[0]);		
		String last_modified_owner = last_Modified_Owner[0];
		System.out.println("********last_Modified_date***"+last_modified_owner);
		
		
		//11) Verify Owner, Created By and Modified By are matching
		String owner = driver.findElementByXPath("(//span[@class='uiOutputText forceOutputLookup'])[1]").getText();
		System.out.println("********owner***"+owner);
		
		String ActualText = "Derrick Dsouza"; 
		Assert.assertEquals(split_created_Owner[0],ActualText);
		Assert.assertEquals(modified_By_Owner[0], ActualText);
		Assert.assertEquals(last_modified_owner, ActualText);
		 
		
		
		//12) Change the Country name To  North America
		driver.findElementByXPath("//input[@placeholder='Country']").clear();
		driver.findElementByXPath("//input[@placeholder='Country']").sendKeys("Mineosta");
		
		//13) Click on Save 
		driver.findElementByXPath("//button[@title='Save']").click();
		
		//14) Verify LastModified date
		String LastModified_date = " 6/11/2022";
		String get_last_Modified = last_Modified_Owner[1];
		Assert.assertEquals(LastModified_date, get_last_Modified);
		
		
		//15) Click on Save
		driver.findElementByXPath("//button[@title='Save']").click();
		 
		//16) Verify  Service Territory is created Successfully		 
		 WebElement ToastMessage = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']")));
		 String getText =  ToastMessage.getText(); 
		 String value = "\"Raja\""; 
		 
		 String t = "Service Territory " + value + " was saved.";
		 System.out.println("********ActualText****************"+t);
		 System.out.println("***********getText*************"+getText);
		 if(getText.contains(t)) { 
			 System.out.println("True"); 
			 }
		 Assert.assertEquals(t, getText);
		 
	}

}
