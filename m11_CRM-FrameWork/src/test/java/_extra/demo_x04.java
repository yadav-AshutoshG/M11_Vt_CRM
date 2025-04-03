package _extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class demo_x04 {

	@Test(priority=-1)
	public void creatCity() {
		System.out.println("Noida");
		
	}
	@Test(priority=0)
	
	public void modifycity() {
		System.out.println("SmartCity");
		Assert.assertTrue(false);
		
	}
	
	
	@Test(priority=1)
	
	public void deleate() {
		System.out.println("DeleateCity");
	}
	
	
}
