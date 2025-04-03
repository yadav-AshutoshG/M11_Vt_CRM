package _propertiesFileData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFileData{ 
	
	public static void main(String[] args)throws InterruptedException, IOException {
		
		
		
		
//		  ####  Not  Working Code  ###
		
//		System.out.println("===Start===");
		

//		#1)
		
		/*
		 * 
		 *
		 * Create Java Representation Object of that Physical File (.properties)
		 */
		FileInputStream fis = new FileInputStream("E:\\javaSelenium\\vtiger-CRM-FrameWork\\src\\test\\resources\\vTiger_CommonData.properties");
		Properties pObj = new Properties();
		
//		##2)
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * Load all The Keys by Using load();
		 * 
		 * ***************************---load() Method--It Will Load Only All The Key.
		 */
		pObj.load(fis);
		
		
		
		
	//	###3)
		/*
		 * 
		 * Getting Data  or Value By Using   getProperty()--Method
		 */
		
		
		String  BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		

		
		
		String USER_NAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

		
		
		
		System.out.println(USER_NAME);
		System.out.println(PASSWORD);
		
		
//		Thread.sleep(3000);
//		System.out.println("====End===");
		
	}

}

