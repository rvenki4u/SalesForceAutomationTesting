package seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_77_CreateServiceTerritories {

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
		
		//7) Click on New 		
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//8) Enter Your Name in Name field
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Ryan");
		
		//9) Click on Operating Hours and Choose the First option
		WebElement operatingHours = driver.findElement(By.xpath("//input[@title='Search Operating Hours']"));
		operatingHours.click();
		WebElement shiftTimings = driver.findElementByXPath("//div[text()='US Shift']");
		shiftTimings.click();
		
		//10) Check Active Field
		WebElement active_Checkbox = driver.findElementByXPath("(//input[@type='checkbox'])[3]");
		driver.executeScript("arguments[0].click();", active_Checkbox);
		
		
		//11) Enter the City your residing in City Field
		driver.findElementByXPath("//input[@placeholder='City']").sendKeys("Chicago");
		
		//12) Enter the State your residing in State Field
		driver.findElementByXPath("//input[@placeholder='State/Province']").sendKeys("Houston");
		//13) Enter the Country your residing in Country Field
		driver.findElementByXPath("//input[@placeholder='Country']").sendKeys("Okhlama");		
		//14) Enter your current Postal Zip Code
		driver.findElementByXPath("//input[@placeholder='Zip/Postal Code']").sendKeys("123456");
		//15) Click on Save
		driver.findElementByXPath("//button[@title='Save']").click();
		//16) Verify Service Territory is created Successfully
		
		WebElement ToastMessage = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']")));
		String getText = ToastMessage.getText();
		String value = "\"Ryan\"";
		

		String ActualText = "Service Territory " + value + " was created.";
		System.out.println("********ActualText****************"+ActualText);
		System.out.println("***********getText*************"+getText);
		if(getText.contains(ActualText)) {		
			System.out.println("True");
		}
		Assert.assertEquals(ActualText, getText);

	}

}
