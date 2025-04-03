package base_utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver;

	@BeforeTest
	public void bt() {
		System.out.println("Pre Condition");

	}

	@BeforeClass
	public void browser() {
		/*
		 * Open the Browser
		 */
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
//		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		Pass Fully Qualified Path Of_Url
		driver.get("http://localhost:8888/");
	}

	@BeforeMethod
	/*
	 * Login
	 */
	public void login() throws InterruptedException {

		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		submitBtn.click();
		Thread.sleep(3000);
	}

	/*
	 * 
	 * 
	 * 
	 */

	@AfterMethod
	/*
	 * Logout
	 */
	public void logout() throws InterruptedException {
		WebElement singOut = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(singOut).build().perform();
		Thread.sleep(3000);
//				Now Here First We find the Particular WebElement 
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(3000);
	}

	@AfterClass
	/*
	 * Close The Browser
	 */
	public void Close_Browser() {
//			driver.close();
		driver.quit();

	}

	@AfterTest
	public void at() {
		System.out.println("Post Condition");
	}

}
