
package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

//	public static void main(String[] args) throws InterruptedException, IOException {
		 public void getDataFromExcelFile() throws EncryptedDocumentException, IOException {
		
		/*
		 * 
		 * 
		 * Excel File 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
//			create java representation object of the physical file
			
			
			
			FileInputStream fis = new FileInputStream("C:\\GET D Folder\\OneDrive\\Desktop\\selPro.xlsx");
			
//			open the workbook in read mode by using create() of workbook_factory
			Workbook wb = WorkbookFactory.create(fis);
				 
//			Method  Chaining
			String data = wb.getSheet("org").getRow(1).getCell(0).getStringCellValue();
			System.out.println(data);

		
		 }
			
			/*
			 * 
			 * 
			 */
		 
		 
		 
		 
		 
		 
		 
//****getData From  Properties File ***//
		/*
		 * Common Data For All Test-Script
		 */

		/*
		 * #**1) Crate Java representation Object Of That Physical file (.properties)
		 */
				 
		 public String getDataFromPropertiesFile(String key) throws InterruptedException, IOException {
		// Pass Full Path Of That File
		FileInputStream fins = new FileInputStream(
				"C:\\GET D Folder\\OneDrive\\Desktop\\00Selenium\\00Project\\Vt_Crm_11\\m11_CRM-FrameWork\\src\\test\\resources\\vTiger_CommonData.properties");
		Properties prObj = new Properties();


		// **2)Load All The Keys By Using load()--Method it will load only All the key
		prObj.load(fins);
		
	String Value =	prObj.getProperty(key);
	return Value;

		/*
		 * 
		 */
		// ***3) Getting data or Value By Using GetProperty()--Method
		
// ****  // 	prObj.getProperty("key");

//		String URL = prObj.getProperty("url");
//		String BROWSER = prObj.getProperty("bro");
//
//		System.out.println(URL);
//		System.out.println(BROWSER);
//
//		String USER_NAME = prObj.getProperty("un");
//		String PASSWORD = prObj.getProperty("pwd");
//
//		System.out.println(USER_NAME);
//		System.out.println(PASSWORD);
//
//		Thread.sleep(3000);
//		return PASSWORD;

	}
}

