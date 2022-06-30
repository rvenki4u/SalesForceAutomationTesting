package seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S03105_AddProductNewCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * 1. Login to https://login.salesforce.com 
		 * 2. Click on toggle menu button from
		 * the left corner 
		 * 3. Click view All 
		 * 4. Click on Content tab 
		 * 5. Click View All Key Deals in Key Deals 6. Click the dropdown from Opportunities and select
		 * All Opportunities 7. Give SRM Steels in Search Box and search 8. Click on the
		 * SRM Steels under Opportunity Name 9. Click on New Case, Click inside the
		 * Contact Name and select the first contact 10. Select Status as New and give
		 * Subject as New case to SRM Steels 11. Click on save
		 */

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

		//4)Click on menu button from the Left corner
		WebElement AppLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		WebDriverWait wait=new WebDriverWait(driver, 50);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
		AppLauncher.click();

		//5) Click 'view All'
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		
		//6)Click on Content tab
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Content']"))).click();
		
		////7)Click View All Key Deals in Key Deals
		driver.findElementByXPath("//span[text()='View All Key Deals']").click();
		
		//8)Click the dropdown from Opportunities and select All Opportunities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Select a List View']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New This Week']"))).click();	
		
		
		WebElement serachTheList = driver.findElementByXPath("(//input[@type='search'])[2]");
		serachTheList.sendKeys("SRM steels");
		Thread.sleep(5000);
		serachTheList.sendKeys(Keys.ENTER);
		/*
		 * Actions action = new Actions(driver); WebElement serachButton = driver.
		 * findElementByXPath("(//*[local-name()='svg' and @data-key='search'])[2]");
		 * action.moveToElement(serachButton).click().perform();
		 */
		
		 

		
		//driver.executeScript("arguments[0].click();", serachButton);
		
		
				

	}

}
