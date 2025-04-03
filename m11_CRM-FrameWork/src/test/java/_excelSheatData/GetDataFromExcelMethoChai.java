package _excelSheatData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelMethoChai {
	
	
//	Excel Data Working  using  Method Chaining
	

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		create java representation object of the physical file
		
		
		
		FileInputStream fis = new FileInputStream("C:\\GET D Folder\\OneDrive\\Desktop\\selPro.xlsx");
		
//		open the workbook in read mode by using create() of workbook_factory
		Workbook wb = WorkbookFactory.create(fis);
			 
//		Method  Chaining
		String data = wb.getSheet("org").getRow(1).getCell(0).getStringCellValue();
		System.out.println(data);

		

	}

}
