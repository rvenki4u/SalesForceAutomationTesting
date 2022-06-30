package seleniumbootcamp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelTestDataProvider extends BaseClass {
	
	
	@DataProvider(name="Employee")
	public String[][] sendDemoData(){

		String data[][] = new String[2][3];

		data[0][0] = "david@gmail.com";
		data[0][1] = "King";
		data[0][2] = "David";

		data[1][0] = "solomon@gmail.com";
		data[1][1] = "King";
		data[1][2] = "Solomon";

		return data;
	}

	@Test(dataProvider="Employee")
	public void f(String emailid,String firstName,String lastName) {

		System.out.println("emailid***"+emailid);
		System.out.println("firstName***"+firstName);
		System.out.println("lastName***"+lastName); 

		//4) Click on Global Actions SVG icon
		driver.findElement(By.xpath("//a[contains(@class,'globalCreateTrigger slds-button slds-button_icon slds-button_icon slds-button_icon-container')]/div")).click();
		//5) After clicking Global Actions SVG icon, Click 'New Contact'.
		driver.findElement(By.xpath("//span[contains(text(),'New Contact')]")).click();
		//6) Pick Salutation as 'Mr.'
		driver.findElement(By.xpath("//a[contains(text(),'--None--')]")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();
		//7) Enter First Name as 'Naveen'
		driver.findElement(By.xpath("//input[@class='firstName compoundBorderBottom form-element__row input']")).sendKeys(firstName); 
		//8) Enter Last Name as 'Elumalai'
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys(lastName);
		//9) Enter email as 'naveen@test.com'
		driver.findElement(By.xpath("//input[@inputmode='email']")).sendKeys(emailid);
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
		WebDriverWait wait=new WebDriverWait(driver, 10);
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
