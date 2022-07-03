package seleniumbootcamp;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class BaseClass {


	ChromeDriver driver;


	@BeforeMethod	
	public void beforeMethod(String url,String username,String password) throws InterruptedException {  		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);				
		
		//1) Launch the app	
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//2) Click Login
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		//3) Login with the credentials
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebElement Login_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Login")));
		Login_Button.click();
	}

	@AfterMethod
	public void afterMethod() {

		driver.close();
	}

}
