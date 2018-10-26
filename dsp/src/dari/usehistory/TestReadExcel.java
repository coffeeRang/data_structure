package dari.usehistory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class TestReadExcel {
	
	public void testReadExcel() {
		try {
			
			// 현재 class의 상대경로를 조회
			String packagePath = TestReadExcel.class.getResource("").getPath();
			String fileName = "sample_data.xlsx";
			
			File file = new File(packagePath + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheetAt(0);
		
			int totalRowNum = sheet.getLastRowNum();
			System.out.println(totalRowNum);
		
			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();	// row 에 해당하는 항목 데이터
			
			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println(">> columnCount : " + columnCount);
			
			ArrayList<String> excelHeaderList = new ArrayList<String>();
			for (int i = 0; i < columnCount; i++ ) {
				excelHeaderList.add((String)row.getCell(i).getStringCellValue());
			}
			
			// 7 : 출발지
			for (String header: excelHeaderList) {
				if (header.equals("출발지")) {
//					System.out.println(header);
				}
			}

			System.out.println("----------------------- 출발지 정보 -----------------------");
			ArrayList<TreeMap<String, Object>> excelList = new ArrayList<TreeMap<String, Object>>();
			while(rowIterator.hasNext()) {
				TreeMap<String, Object> tempArr = new TreeMap<String, Object>();
				row = rowIterator.next();
				
				String startPosNm = row.getCell(7).getStringCellValue();
				tempArr.put("startPosNm", startPosNm);
				
				checkAddMileage(startPosNm);
				
				excelList.add(tempArr);
//				break;
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean checkAddMileage(String startPosNm) {
		boolean flag = false;
		String findValue = ")";
		System.out.println(startPosNm);

		int basicIndex = startPosNm.indexOf(findValue);
		System.out.println(basicIndex);
		if (basicIndex > -1) {
			// ) 항목 존재함
			
		} else {
			// ) 항목 존재 안함
			
			
			// "/" 항목, "]" 항목이 들어간 데이터는 샘플데이터상으로 모두 N/A 이므로 별도 분기처리 X
			
		}
		return flag;
		
	}
	
	public void checkCardOrCash() {
		
	}

}
