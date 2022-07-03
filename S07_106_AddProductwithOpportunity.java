package seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_106_AddProductwithOpportunity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		//1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//2) Click Login
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		//3) Login with the credentials
		driver.findElement(By.id("Login")).click();
				
		//2. Click on View Profile icon
		driver.findElementByXPath("(//span[@class='uiImage'])[1]").click();
		//3. Click on Switch to Salesforce Classic
		driver.findElementByXPath("//a[text()='Switch to Salesforce Classic']").click();
		//4. Click on Create New and Select Account
		
		//5. Enter the Account Name as "BootCamp Puppeteer_<Your Name>"




	}

}
