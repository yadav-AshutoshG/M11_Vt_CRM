package organizationTestModule;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;

public class CreatOrgName extends BaseClass {

	@Test
	public void creatOrgName() throws InterruptedException, IOException {
 
		/*
		 * ** Get Data From properties File ***
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
			FileUtility fu = new FileUtility();
			String Browser = fu.getDataFromPropertiesFile("bro");
			System.out.println(Browser);
		// *** Get Data From Excel***
		/*
		 * 
		 * 
		 */

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * ############## Create Organization Name ###########
		 * 
		 */

		// Open The Browser
//			WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
//		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Pass Fully Qualified Path Of_Url
		driver.get("http://localhost:8888/");

		// Login
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		submitBtn.click();
		Thread.sleep(3000);

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
		if (actOrgName.equals(orgName))
//		if (actOrgName == (orgName))
// 	    if(actOrgName.contains(orgName))
		{
			System.out.println("Organization created successfully");
		}
		Thread.sleep(3000);
// 			 singOut -- USing Mouse Action 
// 			 First We find the Particular WebElement
		WebElement singOut = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
// 			Use Mouse Action Hover
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(singOut).perform();
		Thread.sleep(3000);
// 			Now Here First We find the Particular WebElement 
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(3000);
// 			 close the Browser
		driver.quit();

	}
}
