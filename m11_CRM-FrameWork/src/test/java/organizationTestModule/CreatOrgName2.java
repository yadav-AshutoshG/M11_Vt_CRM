package organizationTestModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreatOrgName2 {
	WebDriver driver;

//	
	@BeforeClass
	void browser() {

//		driver = new FirefoxDriver();
		driver= new ChromeDriver();
//		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		Pass Fully Qualified Path Of_Url
		driver.get("http://localhost:8888/");
	}

	@BeforeMethod
	void login() throws InterruptedException {

		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		submitBtn.click();
		Thread.sleep(3000);
	}

	@Test
	public void creatOrgName() throws InterruptedException {

//		CrateOrganizationName
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		WebElement org = driver.findElement(By.name("accountname"));
		String orgName = "jsp_" + (int) (Math.random() * 1000);
		org.sendKeys(orgName);

		// save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

//		verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully");
		}
	}

	@AfterMethod
	void logout() {
		WebElement singOut = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(singOut).build().perform();
 }
	
	
}
