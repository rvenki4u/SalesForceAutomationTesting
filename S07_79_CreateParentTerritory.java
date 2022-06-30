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

public class S07_79_CreateParentTerritory {

	public static void main(String[] args) throws InterruptedException {
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
		WebDriverWait wait=new WebDriverWait(driver, 50);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
		AppLauncher.click();

		//5) Click on View All
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();

		//6) Click on Service Territories
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Service Territories");
		WebElement Service_Territories = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='slds-truncate']/mark")));	
		Service_Territories.click();

		//7) Click on Parent Territory Input field of newly created Service Territory
		WebElement Parent_Territory = driver.findElementByXPath("//table/tbody/tr[1]/td[5]");		
		boolean isDisplayed = Parent_Territory.isDisplayed();
		Parent_Territory.click();		
		System.out.println("*****Parent_Territory****"+isDisplayed);
		wait.until(ExpectedConditions.elementToBeClickable(Parent_Territory));				
		Parent_Territory.click();

		Thread.sleep(10000);
		//WebElement Pencil_icon = driver.findElementByXPath("//input[@class='splashPage-input splashPage-lookup__search-input']");
		//Pencil_icon.sendKeys("Roger");
		driver.findElementByXPath("(//button[@class='slds-button trigger slds-button_icon-border'])[4]").click();
		driver.findElementByXPath("//span[text()='New Service Territory']").click();

		//9) Enter Name as Ronaldo
		driver.findElementByXPath("(//span[text()='Name'])[2]/following::input[1]").clear();
		driver.findElementByXPath("(//span[text()='Name'])[2]/following::input[1]").sendKeys("Ronaldo");

		//10) Click on Search Operating Hours
		driver.findElementByXPath("//input[@placeHolder='Search Operating Hours...']").click();
		WebElement newOperatingHrs = driver.findElementByXPath("//span[@title='New Operating Hours']");
		newOperatingHrs.click();

		//11)  Click New Operating Hours in the DropDown
		WebElement newoperhrs_Name = driver.findElementByXPath("//h2[text()='New Operating Hours']/following::input");

		//12) Enter Name as Mukesh Ambani
		newoperhrs_Name.clear();
		newoperhrs_Name.sendKeys("Ronaldo");

		//13) Select Time as India standard Time(Asia/Kolkata)
		WebElement time_Zone = driver.findElementByXPath("//span[text()='Time Zone']/following::a");
		time_Zone.click();
		WebElement timeZone = driver.findElementByXPath("//a[text()='(GMT+05:30) India Standard Time (Asia/Kolkata)']");
		timeZone.click();
		//boolean timeZoneisSelected = timeZone.;		
		//System.out.println("***timeZoneisSelected****"+timeZoneisSelected);

		//14) Click on Save
		//Thread.sleep(5000);
		WebElement Save_Button = driver.findElementByXPath("(//button[@title='Save'])[2]");
		driver.executeScript("arguments[0].click();", Save_Button); 

		//span[@data-aura-class='forceActionsText']


		//17) Verify Whether Parent Territory is Created Successfully WebElement		
		String getText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']"))).getText();
		String value = "\"Ronaldo\"";				 
		String ActualText = "Operating Hours " +value+ " was created.";
		System.out.println("********ActualText****************"+ActualText);
		System.out.println("***********getText*************"+getText);
		Assert.assertEquals(ActualText, getText);

		Thread.sleep(5000);
		WebElement Service_Territory_SaveButton = driver.findElementByXPath("(//span[text()='Save'])[2]");
		driver.executeScript("arguments[0].click();", Service_Territory_SaveButton);



		//17) Verify Whether Parent Territory is Created Successfully WebElement		
		String servicegetText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))).getText(); 
		String serviceValue = "\"Ronaldo\""; 
		String serviceActualText = "Service Territory " +serviceValue+ " was created.";
		System.out.println("********serviceActualText****************"+serviceActualText);
		System.out.println("***********servicegetText*************"+servicegetText);
		Assert.assertEquals(serviceActualText, servicegetText);


		
	}

}
