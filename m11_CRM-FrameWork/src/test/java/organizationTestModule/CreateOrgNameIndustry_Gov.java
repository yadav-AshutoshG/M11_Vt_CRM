package organizationTestModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrgNameIndustry_Gov {

	@Test(groups="regression")
	public void createOrgName_Industry_Gov() throws InterruptedException {
		System.out.println("regression");
//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
//		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("http://localhost:8888/");

		// Login
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		submitBtn.click();

// 		CreatOrganizationNAme
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		WebElement org = driver.findElement(By.name("accountname"));
		String orgName = "jsp_" + (int) (Math.random() * 1000);
		org.sendKeys(orgName);

// 		Here we use 'Select_Class' for Handling DroDown
// 		Industry
		WebElement dropDownIndustryElement = driver.findElement(By.xpath("//select[@name='industry']"));
		Select dropDownIndustry = new Select(dropDownIndustryElement);
	     dropDownIndustry.selectByVisibleText("Government");

		String industry = "Government";

	     Thread.sleep(3000);
		// save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		 Thread.sleep(3000);
		// verification
// 		Verify Organization
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName));
		{
			System.out.println("Verifyed Organization created successfully");
		}
		 Thread.sleep(3000);
		 
		// verify Industry
		String actIndustryName = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustryName.contains(industry));
		{
			System.out.println("Verifyed IndustryGov created successfully");
		}
		 Thread.sleep(3000);
		 /*
		  * 
		  */
// 			 singOut -- Using Mouse Action 
// 			 First We find the Particular WebElement
		WebElement singOut = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		 Thread.sleep(3000);
// 			Use Mouse Action Hover
		Actions act = new Actions(driver);
		act.moveToElement(singOut).perform();
		 Thread.sleep(3000);
// 			Now Here First We find the Particular WebElement 
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		 Thread.sleep(3000);
// 			 close the Browser
		driver.quit();

	}

}
