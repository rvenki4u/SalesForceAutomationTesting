package seleniumbootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGInvocationCount {
  @Test(threadPoolSize = 3,invocationCount=3)
  public void f() throws InterruptedException {
	  
	 
	    WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		//1) Launch the app	
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//2) Click Login
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel@123");
		//3) Login with the credentials
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebElement Login_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Login")));
		Login_Button.click();
		//4) Click on Global Actions SVG icon
		driver.findElement(By.xpath("//a[contains(@class,'globalCreateTrigger slds-button slds-button_icon slds-button_icon slds-button_icon-container')]/div")).click();
		//5) After clicking Global Actions SVG icon, Click 'New Contact'.
		driver.findElement(By.xpath("//span[contains(text(),'New Contact')]")).click();
		//6) Pick Salutation as 'Mr.'
		driver.findElement(By.xpath("//a[contains(text(),'--None--')]")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();
		//7) Enter First Name as 'Naveen'
		driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys("Viduthalai"); 
		//8) Enter Last Name as 'Elumalai'
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Nayagam");
		//9) Enter email as 'naveen@test.com'
		driver.findElement(By.xpath("//input[@inputmode='email']")).sendKeys("naveen@test.com");
		//10) Create a New Account for Account Name
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search Accounts')]")).click();
		driver.findElement(By.xpath("//span[@title='New Account']")).click();
		//11) Enter account name as 'Credits' and save
		driver.findElement(By.xpath("(//span[text()='Account Name'])[2]/following::input[1]")).sendKeys("Credits");
		//div[contains(@class,'uiInput uiInputText uiInput--default uiInput--input')]/following::input
		//12) Click and save
		driver.findElement(By.xpath("//button[@data-aura-class='uiButton--default uiButton--brand uiButton forceActionButton']/span")).click();
		//13) Verify contact using Unique name and print the name
		WebElement ToastMessage = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']")));
		String getText = ToastMessage.getText();
		String value = "\"Credits\"";
		
		String ActualText = "Account " + value + " was created.";
		System.out.println("********ActualText****************"+ActualText);
		System.out.println("***********getText*************"+getText);
		if(getText.contains(ActualText)) {		
			System.out.println("True");
		}
		Assert.assertEquals(ActualText, getText);
		//click the logout image
		WebElement Logout_Image = driver.findElement(By.xpath("(//span[@data-aura-class='uiImage'])[9]"));
		WebDriverWait wait1=new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@data-aura-class='uiImage'])[9]")));
		Logout_Image.click();
		//click the logout link
		WebElement Logout_Link = driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
	    WebDriverWait wait2=new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Log Out')]")));
		Logout_Link.click();
  }
}
