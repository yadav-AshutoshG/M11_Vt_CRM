package extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Add_Num {

//	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	@Test
	public void add() {
		WebDriver driver = new ChromeDriver() ;
		System.out.println(1+1);
		Reporter.log("Hey there !");
	}
	

}


//}
