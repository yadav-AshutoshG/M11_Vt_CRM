package organizationTestModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOrgNameOrIndusGov_PhonNum {

	@Test(groups = "smoke")
	public void createOrgNameOrPhonNum() throws InterruptedException {
		System.out.println("sirf smoke");
		WebDriver driver = new ChromeDriver();
		
//		WebDriver driver = new EdgeDriver();
//		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Pass Fully Qualified Path Our LOcalHOst in "String Format"
		driver.get("http://localhost:8888/");
		
		
		
//		 login

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();

		
//		CreatOrganizationName Indus_Gov.  With Phone Number
		driver.findElement(By.linkText("Organizations")).click();

//		Click On the  Plus Button
		driver.findElement(By.cssSelector("img[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
         
		/*
		 * 
		 */
//		Create OrganiZation Name 
		WebElement Org = driver.findElement(By.name("accountname"));
		String OrgName = "Jsp_" + (int) (Math.random() * 9000);
		Org.sendKeys(OrgName);
		/*
		 * 
		 */
//		Create  Indus_Gov
//		  Industry
		WebElement dropDownIndustryElement = driver.findElement(By.xpath("//select[@name='industry']"));
		Select dropDownIndustry = new Select(dropDownIndustryElement);
	     dropDownIndustry.selectByVisibleText("Government");

		String industry = "Government";

	     Thread.sleep(3000);
		
		/*
		 * 
		 * 
		 */

//		and Phone Number
		WebElement PhNoTxtfeild = driver.findElement(By.id("phone"));
		PhNoTxtfeild.sendKeys("8208082080");

//		 save the Data
		driver.findElement(By.xpath("//input[@accesskey='S']")).click();

		
		
//		Verification 
//		 Organization
		String actOrg = driver.findElement(By.id("dtlview_Organization Name")).getText();

		if (actOrg.contains(OrgName)) {

			System.out.println("OrganizationName is  Created Successfully");
		} else {
			System.out.println("Not Created");
		}
		/*
		 * 
		 * Verification
		 * Industry_Gov.
		 */
		String actIndustryName = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustryName.contains(industry));
		{
			System.out.println("Verifyed IndustryGov created successfully");
		}
		 Thread.sleep(3000);
		/*
		 * 
		 */
		
		
//		Verification 
//		 PhoneNo.
		String actPhNo = driver.findElement(By.id("dtlview_Phone")).getText();

		if (actPhNo.equals("8208082080")) {

			System.out.println("PhoneNumber is Created Successfully");
		} else
		
		 {
			System.out.println("Not Created");
		 }
		
		Thread.sleep(2000);
		/*
		 * 
		 * 
		 */
		
//		 singOut -- Using Mouse Action 
//		 First We find the Particular WebElement
		WebElement singOut = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));

		Thread.sleep(2000);
//		Use Mouse Action Hover
		Actions act = new Actions(driver);
		act.moveToElement(singOut).perform();

		Thread.sleep(2000);
//		Now Here First We find the Particular WebElement 
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		Thread.sleep(2000);
//		 close the Browser
		driver.quit();
		

	}

}
