package dari.usehistory;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestMain {
	
	public static void main(String[] args) {
		TestReadExcel test = new TestReadExcel();
		
//		System.out.println(test.testReadExcel().size());
		
		ArrayList<TreeMap<String, Object>> tempArr =  test.testReadExcel();
		
		// 값 확인하기 위한 임시 배열
		String[] paymentTypeArr = {"", "현금", "카드", "마일리지(전부)", "마일리지(일부사용)", "지원금"};
		
		for (int i = 0; i < tempArr.size(); i ++) {
			System.out.println(tempArr.get(i));
		}
		
		
	}

}
