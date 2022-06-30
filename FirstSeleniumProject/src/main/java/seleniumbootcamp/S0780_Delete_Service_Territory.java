package seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S0780_Delete_Service_Territory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		/*
		 * 6) Click on Service Territories 7) Under Service Territories on Left Corner
		 * Click the Dropdown Option 8) Select All ServiceTerritories 9) Select The
		 * Newly created Service territory ,Click on the Dropdown Icon on right Corner
		 * 10) Click on delete 11) Click on Delete on Confirmation box 12) Verify
		 * Whether the Service Territory is deleted Successfully
		 */

		//1) Launch the app
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		//2) Click Login	
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//3) Login with the credentials
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
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View All']"))).click();
		
		//6) Click on Service Territories
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service Territories");		
		WebElement Service_Territories = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='slds-truncate']/mark")));
		Service_Territories.click();
		
		//Thread.sleep(5000);
		
		//button[@title='Select a List View']
		
		//8) Select All ServiceTerritories
		WebElement All_Service_Territory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Service Territories'])[3]/following-sibling::span")));
		All_Service_Territory.click();

		boolean All_Service_Territory_is_displayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='List Views']"))).isDisplayed();
		System.out.println("*****All_Service_Territory_is_displayed*****"+All_Service_Territory_is_displayed);

		WebElement All_Service_Territories = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='All Service Territories']")));
		boolean All_Service_Territories_is_displayed =  All_Service_Territories.isDisplayed();
		System.out.println("*****All_Service_Territories_is_displayed*****"+All_Service_Territories_is_displayed);
		All_Service_Territories.click();


		/*
		 * driver.findElementByXPath("(//button[@title='Select a List View'])[2]").click
		 * (); WebElement All_Service_Territory =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("(//button[@title='Select a List View'])[2]")));
		 * All_Service_Territory.click();
		 */

		//9) Select The Newly created Service territory ,Click on the Dropdown Icon on right Corner
		String serviceTerritoryName = "Venkat B";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='ServiceTerritory-search-input']")));
		WebElement searchTextbox = driver.findElementByXPath("//input[@name='ServiceTerritory-search-input']");
		searchTextbox.sendKeys(serviceTerritoryName);
		Thread.sleep(3000);
		searchTextbox.sendKeys(Keys.ENTER);

		//10) Click on delete
		WebElement showAction = wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//a[@title='Venkat B']/../../..//a)[3]")));																							
		driver.executeScript("arguments[0].click();", showAction);
		driver.findElementByXPath("//a[@title='Delete']").click();
		Thread.sleep(5000);
		
		//11) Click on Delete  on Confirmation box
		driver.findElementByXPath("//span[text()='Delete']").click();

		//12) Verify Whether the Service Territory is deleted Successfully
		//12)Verify the Deleted Contact
		
		WebElement ToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']")));
		String getText =  ToastMessage.getText(); 
		//String value = ""\"James George\""; 

		String t = "Service Territory \"Venkat B\" was deleted. Undo";

		System.out.println("********ActualText****************"+t);
		System.out.println("***********getText*************"+getText);
		Assert.assertEquals(t, getText);



	}

}
