package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility1 {
	public String getDataFromPrpertyFiles(String key) throws IOException {

		FileInputStream fi = new FileInputStream(
				"E:\\javaSelenium\\vtiger-CRM-FrameWork\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fi);
		String getValuString = pObj.getProperty(key);
		return getValuString;

	}

	public void getDataFromExcelFile(String name, int rownum, int cellnum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\GET D Folder\\OneDrive\\Desktop\\selPro.xlsx");

//		open the workbook in read mode by using create() of workbookfactory
		Workbook wb = WorkbookFactory.create(fis);

//		get the access of sheet by using getSheet()
		Sheet sh = wb.getSheet(name);

//		get the access of row by using getRow()
		Row row = sh.getRow(rownum);

//		get the access of the cell by using getCell()
		Cell cell = row.getCell(cellnum);

//		get data of the cell by using getStringCellValue() or getNumericCellValue()
		String data = cell.toString();

//		return data;
		System.out.println(data);

	}

}
