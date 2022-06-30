package seleniumbootcamp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice extends BaseClass {


	@Test(priority = 1,threadPoolSize = 3,invocationCount = 3)
	public void CreateContact() {
		
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
	@Test(priority = 2, enabled=false)
	public void EditContact() throws InterruptedException {
		//4)Click on menu button from the Left corner
		WebElement AppLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		WebDriverWait wait=new WebDriverWait(driver, 30);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
		AppLauncher.click();
		//5) Click 'view All'
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		//6) Click on contacts
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contacts");
		WebElement Contacts_Link = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='slds-truncate']/mark")));	
		Contacts_Link.click();
		//7) Get the size of contacts available and print the list
		WebElement contactsTable = driver.findElementByXPath("//table[@role='grid']/tbody");
		List<WebElement> rows = contactsTable.findElements(By.tagName("tr"));	
		System.out.println("****size of contacts*****"+rows.size());	
		for(WebElement a :rows)
			System.out.println("Contacts--->"+a.getText());
		//8) search for the contact using unique name
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
		WebElement serachTextbox = driver.findElementByXPath("//input[@placeholder='Search this list...']");
		serachTextbox.sendKeys("Viduthalai Nayagam");
		serachTextbox.sendKeys(Keys.ENTER);	
		Thread.sleep(5000);
		
		//9)Click on the dropdown icon available in the unique contact and select edit
		    //WebElement showAction = driver.findElementByXPath("//tbody/tr[1]/td[8]//*[local-name()='svg']");
		WebElement showAction = driver.findElementByXPath("//tbody/tr[1]/td[8]//a");
		wait.until(ExpectedConditions.visibilityOf(showAction));
		new Actions(driver).moveToElement(showAction).click().perform();
		
		//10) Edit Title as Test
		Thread.sleep(5000);
		driver.findElementByXPath("//a[@title='Edit']").click();
		driver.findElementByXPath("//input[@name='Title']").sendKeys("Test");	
	    driver.findElementByXPath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']/input").click();
		
	    //11) select your birthday in the birthday field
	    driver.findElementByXPath("(//label[text()='Birthdate']/following::button)[1]").sendKeys("10/1/1987");
	    
	    //12) edit Lead Source as Purchased list
	    WebElement Lead_Source = driver.findElementByXPath("(//label[text()='Lead Source']/following::button)[1]");
		Lead_Source.click();	  
		Thread.sleep(5000); 
		driver.findElementByXPath("//span[text()='Purchased List']").click();
		
	    //13) Edit Phone number with personal number
		driver.findElementByXPath("//input[@name='Phone']").sendKeys("9865056602");
		
	    //14) Click Save and Verify and Print Phone number
		driver.findElementByXPath("//button[text()='Save']").click();		

	}
	@Test(priority = 3,enabled=false)
	public void DeleteContact() throws InterruptedException {
		
		//4) Click on the App Laucher Icon left to Setup
				WebElement AppLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
				WebDriverWait wait=new WebDriverWait(driver, 30);	
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='slds-icon-waffle']")));
				AppLauncher.click();

				//5) Click on View All
				WebElement ViewAll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button']")));
				ViewAll.click();
				
				//6) Click on Contacts
				driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Contacts");
				WebElement Contacts = driver.findElement(By.xpath("//p[@class='slds-truncate']/mark"));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='slds-truncate']/mark")));	
				Contacts.click();
				Thread.sleep(5000);
				
				
				//8) Get the size of conatcts available and print the list		
				List<WebElement> li = driver.findElements(By.xpath("(//table[1]/tbody/tr[1])[1]/following-sibling::tr"));
//				List<WebElement> li = driver.findElements(By.xpath("//table/tbody/tr"));
				
				int listSize = (li.size()+1);
				System.out.println("List Size--->"+listSize);
				
				
				for(int i=1;i<=li.size()+1;i++) {			
					String contact_Name = driver.findElementByXPath("//table/tbody/tr["+i+"]/th//a").getAttribute("title");			
					System.out.println("&&&&contact_Name&&&"+contact_Name);			
				}
				
				
				  //9) search for the contact using unique name
				  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Contact-search-input']"))); 
				  WebElement searchTextbox = driver.findElementByXPath("//input[@name='Contact-search-input']");
				  searchTextbox.sendKeys("Naveen Elumalai"); searchTextbox.sendKeys(Keys.ENTER);
				  Thread.sleep(5000);
				  
				  //10) Get the text of Contact name and store it
				  driver.findElementByXPath("//input[@placeholder='Search this list...']").click();
				  
				  
				  //11) Get the text of Contact name and store it
				  WebElement showAction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[1]/td[8]//a")));		 
				  driver.executeScript("arguments[0].click();", showAction);
				  driver.findElementByXPath("//a[@title='Delete']").click();
				  driver.findElementByXPath("//span[text()='Delete']").click();
				  
				  
				  //12)Verify the Deleted Contact WebElement ToastMessage =		  
				  WebElement ToastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceActionsText']"))); 
				  String getText = ToastMessage.getText();
				  //String value = ""\"James George\"";
				  
				  String t = "Contact \"Naveen Elumalai\" was deleted. Undo";
				  
				  System.out.println("********ActualText****************"+t);
				  System.out.println("***********getText*************"+getText);
				  Assert.assertEquals(t, getText);


	}
}
