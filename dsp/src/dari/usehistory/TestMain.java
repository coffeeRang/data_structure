package dari.usehistory;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestMain {
	
	public static void main(String[] args) {
		TestReadExcel test = new TestReadExcel();
		
		test.testReadExcel();
		
		
	}

}
