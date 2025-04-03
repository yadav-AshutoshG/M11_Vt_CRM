package organizationTestModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo3 {

	
		@Test(invocationCount = 100, threadPoolSize = 25)
		public void chrome() {
			WebDriver driver = new ChromeDriver();
			
			driver.close();
			
		
	}
}
