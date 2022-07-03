package seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_106_AddProductwithOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//1. Login to https://login.salesforce.com
		//2. Click on toggle menu button from the left corner
		//3. Click view All
		//4. Click on Content tab 
		//5. Click View All Key Deals in Key Deals 
		//6. Click the dropdown from Opportunities and select All Opportunities
		//7. Give SRM Steels in Search Box and search
		//8. Click on the SRM Steels under Opportunity Name
		//9. Click on  dropdown of Products under Related and select Add Products
		//10. Click on List Price to sort the result and select the highest priced product
		//11. Click Next and give product Quantity as 560, click Save
		//12. Verrify the Sales Price and Product Name

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		WebDriverWait wait=new WebDriverWait(driver, 50);
		//1. Login to https://login.salesforce.com
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
		AppLauncher.click();

		//5) Click 'view All'
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();

		//6)Click on Content tab
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Content']"))).click();

		//7)Click View All Key Deals in Key Deals
		driver.findElementByXPath("//span[text()='View All Key Deals']").click();

		//8)Click the dropdown from Opportunities and select All Opportunities
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Select a List View']"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New This Week']"))).click();
		
		WebElement serachTheList = driver.findElementByXPath("(//input[@type='search'])[2]");
		serachTheList.sendKeys("SRM steels");
		Thread.sleep(5000);
		serachTheList.sendKeys(Keys.ENTER);
		
		// 8. Click on the SRM Steels under Opportunity Name
		driver.findElementByXPath("(//a[text()='SRM Steels'][@title='SRM Steels'])[1]").click();
		
		//9.Click on dropdown of Products under Related and select Add Products
		
		



	}

}
