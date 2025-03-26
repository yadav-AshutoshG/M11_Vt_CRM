package opportunityTestModule;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class _06_CreateOppWithOrg_BussType_Date {
	
	@Test
	public void createOppWithOrg_BussType_Date() throws InterruptedException {
		// TODO Auto-generated method stub



		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Pass Fully Qualified Path
		driver.get("http://localhost:8888/");

//		Login
		driver.get("http://localhost:8888/");
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement submitBtn = driver.findElement(By.id("submitButton"));
		submitBtn.click();
/*
 * 
 * 
 */
		
//		Create Opportunity
		driver.findElement(By.linkText("Opportunities")).click(); // Here We Click On "Opportunities" Module
		WebElement PLUSimg = driver.findElement(By.xpath("//img[@alt='Create Opportunity...']"));
		PLUSimg.click(); // To Create A New Opportunity

//		Send Opportunity  Name in the  Text Area 
		WebElement Name = driver.findElement(By.className("detailedViewTextBox"));
		String OppName = "Jsp_" + (int) (Math.random() * 1000);
		Name.sendKeys(OppName);
		
		
		
		/*
		 * 
		 *    ****Now Handle Child Window***
		 *    
		 *    
		 *    First store ParentId
		 */
				String ParentId = driver.getWindowHandle();

//				Click on Plus Img
				driver.findElement(By.xpath("//input[@id='related_to_display']/following-sibling::img")).click();
//		      Open New  child window
				Set<String> AllId = driver.getWindowHandles();
				AllId.remove(ParentId); // ***Here we Removed The Parent Session Id****
		/*
		 * 
		 * 
		 */
//			*****	Switching to Particular child winDow  *****

				for (String id : AllId) {
					driver.switchTo().window(id);
					if (driver.getCurrentUrl().contains("module=Accounts&action")) {

						break;
					}

				}
				
				
				/*
				 * 
				 * 
				 */
				

				/**** Sending The Organization Name { "qsp_" } *****/

				String OrgName = "qsp_";
				driver.findElement(By.id("search_txt")).sendKeys(OrgName);
				driver.findElement(By.name("search")).click();

//				Dynamic path
				driver.findElement(By.xpath("//a[text()='" + OrgName + "']")).click();

				
				
				/*
				 * 
				 * 
				 */
				/***** Now we Are SwitchTo Driver in the Parent Window *****/
				
				driver.switchTo().window(ParentId);
		        Thread.sleep(2000);
		        
		        /*
		         *
		         * 
		         * 
		         */
		        
		        


//		      ****  Using Drop Down (Select Class) Business Type  ****
				WebElement Busintype = driver.findElement(By.name("opportunity_type"));
				Select sel = new Select(Busintype);
				
				String selName= "New Business";
				sel.selectByValue(selName);
				
				WebElement selFirst = sel.getFirstSelectedOption();
				System.out.println(selFirst.isSelected());

				/*
				 * 
				 * 
				 */

		        
//				  ***** Handle the Calendar Date  ****.
		        /*
		         *
		         */
		        
			WebElement date =	driver.findElement(By.id("jscal_field_closingdate"));
				String currDate = date.getText();
		        
		         
               /*
                *
                *
                *
                *
                */
		        
		        		        
//		    	
////				***Save  The  Data   ****//

			Thread.sleep(2000);
			/*** Click on Save 'btn'*****
			 * Here 4 Type of Save Btn Are Available 2 Are Hidden ******* we use Xpath Two
			 * Way (1)By Surroundings (2)By Indexing (//input[@class='crmbutton small
			 * save'])[1]
			 ****/
			driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	/*
	 * 
	 * 
	 * 
	 */
//			Verification
//			**Opportunities_Name  Creation**
			Thread.sleep(2000);
			String actOppName = driver.findElement(By.id("dtlview_Opportunity Name")).getText();
			if (actOppName.equals(OppName)) {
				System.out.println("Opportunities_Name created verified successfully");
			}
			Thread.sleep(2000);

//	         Verification
//	          **  Organization  **

			String actOrgName = driver.findElement(By.xpath("//a[text()='qsp_']")).getText();
			boolean status = actOrgName.equals(OrgName);
			if (status) {
				System.out.println("Organization verified successfully");
			}
			Thread.sleep(2000);
			
//			Verification
//			    ** Business Type **
			String actBusinessType = driver.findElement(By.id("dtlview_Type")).getText();
	    	
	    	boolean status2 = actBusinessType.equals(selName);
	    	if (status2) {
	    		System.out.println("BusinessTypeSelected verified successfully");
	    	}
	    	
	    	
//	    	Verification 
//	    	   ** Date Type **
	     
	    	
	    	String actDate = driver.findElement(By.xpath("//td[text()='Expected Close Date']/../td[4]")).getText();
	    	if(actDate.contains(currDate)) {
	    		System.out.println("Date Verification Succesfully");
	    	}
					
//		****	Here  To  Add More   Verification   ***
			
		/*
		 * 
		 *******/
				

//	  	####****      Now logout  The WebPage     ***#####
			
			WebElement WEprofile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
	/*	*** 	WEprofile    to hover mouse 
	 * We use Mouse Action Class 
	 * To Hover The Mouse Cursor on the Particular Element
	 * moveToElement()  
	 */
			Actions act = new Actions(driver);
			  act.moveToElement(WEprofile).build().perform();
			  Thread.sleep(1000);
			  
			  
		/*	  ****Sign Out***
			  Now We Click on the Sign Out
			  */
			  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//				driver.findElement(By.linkText("Sign Out")).click();
			  
			
			
			
			
		
				
				
	/*		closing browser  ***quit();
	 * This Method Will Close All The Window
	 * Also Terminate The Browser
	 */	
		        driver.quit();
	 
		
		

	}

}
