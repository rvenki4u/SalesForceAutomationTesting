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

public class S07105_Create_Opportunity {

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
		//4)Click on menu button from the Left corner
		WebElement AppLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		WebDriverWait wait=new WebDriverWait(driver, 50);	
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
		
		Thread.sleep(5000);
		//9)click on New
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='New']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Name']"))).sendKeys("SRM Steels");
		
		//10) Select Type as New Customer and Lead Source as Partner Referral
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='CloseDate']"))).sendKeys("08/12/2022");
		
		//span[@title='New Customer'
		Thread.sleep(5000);
		WebElement type_Dropdown = driver.findElement(By.xpath("(//button[@data-value='--None--'])[2]/following::lightning-primitive-icon"));
		driver.executeScript("arguments[0].click();", type_Dropdown);
		
		Thread.sleep(5000);
		WebElement active_Checkbox = driver.findElementByXPath("//span[@title='New Customer']");		
		driver.executeScript("arguments[0].click();", active_Checkbox);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='New Customer']"))).isSelected();
		
		Thread.sleep(5000);
		WebElement Lead_Dropdown = driver.findElement(By.xpath("(//button[@data-value='--None--'])[2]/following::lightning-primitive-icon"));
		driver.executeScript("arguments[0].click();", Lead_Dropdown);
		
		Thread.sleep(5000);
		WebElement Lead_Source = driver.findElementByXPath("//span[@title='Partner Referral']");		
		driver.executeScript("arguments[0].click();", Lead_Source);
		
		//10.Give Amount as 75000 and Select Close Date as Next month 20th day 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Amount']"))).sendKeys("7500");
		
		//11. Select Stage as Needs Analysis
		Thread.sleep(6000);
		WebElement stage_Dropdown = driver.findElement(By.xpath("(//button[@data-value='--None--'])[1]/following::lightning-primitive-icon"));
		driver.executeScript("arguments[0].click();", stage_Dropdown);		
		
		Thread.sleep(5000);
		WebElement Lead_Stage = driver.findElementByXPath("//span[@title='Needs Analysis']");		
		driver.executeScript("arguments[0].click();", Lead_Stage);
		
		//12. Click in Primary Campaign  Source and Select first option
		WebElement primary_Campaign = driver.findElement(By.xpath("(//label[text()='Primary Campaign Source']/following::input)[1]"));
		driver.executeScript("arguments[0].click();", primary_Campaign);
		
		Thread.sleep(5000);
		WebElement primary_Campaign_source = driver.findElementByXPath("//span[@title='Bootcamp']");		
		driver.executeScript("arguments[0].click();", primary_Campaign_source);
		
		//13. Click Save and Verify the SRM Steels opportunity is create
		driver.findElementByXPath("//button[text()='Save']").click();
		
		//13) Verify contact using Unique name and print the name
		WebElement ToastMessage = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']")));
		String getText = ToastMessage.getText();
		String value = "\"SRM Steels\"";
		
		String ActualText = "Opportunity "  + value + " was created.";
							System.out.println("********ActualText****************"+ActualText);
		System.out.println("***********getText*************"+getText);
		if(getText.contains(ActualText)) {		
			System.out.println("True");
		}
		Assert.assertEquals(ActualText, getText);
		//click the logout image
		WebElement Logout_Image = driver.findElement(By.xpath("(//span[@data-aura-class='uiImage'])[9]"));
		WebDriverWait wait1=new WebDriverWait(driver, 40);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@data-aura-class='uiImage'])[9]")));
		Logout_Image.click();
		//click the logout link
		WebElement Logout_Link = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
	    WebDriverWait wait2=new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Log Out')]")));
		Logout_Link.click();			
		
	}

}
