package _excelSheatData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetdataFromExcelFile {

//	#### Not  Working Code  ###
	
	

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("E:\\javaSelenium\\vtiger-CRM-FrameWork\\src\\test\\resources\\selPro.xlsx");

//		open the workbook in read mode by using create() of_workbookfactory
		Workbook wb = WorkbookFactory.create(fis);
		
//		get the access of sheet by using getSheet()
		Sheet sh = wb.getSheet("org");
		
//		get the access of row by using getRow()
		Row row = sh.getRow(1);
		
//		get the access of the cell by using getCell()
		Cell cell = row.getCell(0);
		
//		get data of the cell by using getStringCellValue() or getNumericCellValue()
		String data = cell.toString();
		
//		return data;
		System.out.println(data);
		
		
	}

}
