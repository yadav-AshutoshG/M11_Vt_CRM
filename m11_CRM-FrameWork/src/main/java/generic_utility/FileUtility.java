//
//  package generic_utility;
// 
//
//
// import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//
//public class FileUtility {
//	public String getDataFromPropFile(String key) throws IOException{
////****getData From  Properties File ***//
//	/*
//	 * Common Data For All   Test-Script 
//	 */
//	
//	
///*	#**1)
// * Crate Java  representation Object Of That Physical file 
// *                                          (.properties)
// */
//	//Pass Full Path Of That File 
//	FileInputStream fins = new FileInputStream("E:\\javaSelenium\\vtiger-CRM-FrameWork\\src\\test\\resources\\CommonData.properties");
//	Properties prObj = new Properties();
//	
//	//   **2)Load All The  Keys By Using  load()--Method it will load only All  the key
//	prObj.load(fins);
//	
//	
//	//***3)  Getting data or Value By Using GetProperty()--Method
//	return prObj.getProperty(key);
//			
//	
////	String BROWSER = prObj.getProperty(BROWSER);    
////    System.out.println("BROWSER");
//	
//	
//	/*
//	 * 
//	 * 
//	 * 
//	 * 
//	 * 
//	 * 
//	 * 
//	 * 
//	 * 
//	 * ********  Hare To write  **** 
//	 * 
//	 */
//	
//	
////	
////	
//////	System.out.println("Hello");
//////	#1)
////	
////	/*
////	 * 
////	 * Create Java Representation Object of that Physical File (.properties)
////	 */
////	FileInputStream fis = new FileInputStream("E:\\javaSelenium\\vtiger-CRM-FrameWork\\src\\test\\resources\\CommonData.properties");
////	Properties pObj = new Properties();
////	
//////	##2)
//	/*
//	 * 
//	 * 
//	 * 
//	 * 
//	 * 
//	 * Load all The Keys by Using load();
//	 * 
//	 * ***************************---load() Method--It Will Load Only All The Key.
//	 */
//	pObj.load(fis);
//	
//	
//	
////	###3)
//	/*
//	 * 
//	 * Getting Data  or Value By Using   getProperty()--Method
//	 */
//	String  BROWSER = pObj.getProperty("bro");
//	String URL = pObj.getProperty("url");
//	
//	System.out.println(URL);
//	System.out.println(BROWSER);
//	
//	String URL = pObj.getProperty("url");
//	String BROWSER = pObj.getProperty("bro");
//	String USER_NAME = pObj.getProperty("un");
//	String PASSWORD = pObj.getProperty("pwd");
//	
//	System.out.println(URL);
//	System.out.println(BROWSER);
//	System.out.println(USER_NAME);
//	System.out.println(PASSWORD);
//	Thread.sleep(3000);
//	System.out.println("Hello");
//	
//	
//}
//}
//
//*/
