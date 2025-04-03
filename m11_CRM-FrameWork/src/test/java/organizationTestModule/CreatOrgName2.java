package organizationTestModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_utility.BaseClass;

public class CreatOrgName2 extends BaseClass {

	/*
	 * Our Main Test Script
	 */
	@Test()
	public void creatOrgName() throws InterruptedException {

//		CrateOrganizationName
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

		WebElement org = driver.findElement(By.name("accountname"));
		String orgName = "jsp_" + (int) (Math.random() * 9000);
		org.sendKeys(orgName);

		// save
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

//		verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println("Organization created successfully");
		}
	}

}
