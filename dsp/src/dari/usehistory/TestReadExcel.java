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
	
//	public void testReadExcel() {
	public ArrayList<TreeMap<String, Object>> testReadExcel() {
		try {
			
			// 현재 class의 상대경로를 조회
			String packagePath = TestReadExcel.class.getResource("").getPath();
//			String fileName = "sample_data.xlsx";
			String fileName = "data_by_m9, m10.xlsx";
			
			File file = new File(packagePath + fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = workbook.getSheetAt(0);
		
			int totalRowNum = sheet.getLastRowNum();	// 엑셀파일 총 row count
		
			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();	// row 에 해당하는 항목 데이터
			
			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();	// 엑셀파일 총 column count
			
			ArrayList<String> excelHeaderList = new ArrayList<String>();

			// column 최상단 값을 excelHeader에 할당
			for (int i = 0; i < columnCount; i++ ) {
				excelHeaderList.add((String)row.getCell(i).getStringCellValue());
			}
			
			// 7 : 출발지
			for (String header: excelHeaderList) {
				if (header.equals("출발지")) {
//					System.out.println(header);
				}
			}
			
			// payment type arr
			String[] paymentTypeArr = {"", "현금", "카드", "마일리지(전부)", "마일리지(일부사용)", "지원금"};
			String[] analysisResultCdArr = {"S", "E"};

			System.out.println("----------------------- 출발지 정보 -----------------------");
			ArrayList<TreeMap<String, Object>> excelList = new ArrayList<TreeMap<String, Object>>();

			while(rowIterator.hasNext()) {
				TreeMap<String, Object> tempArr = new TreeMap<String, Object>();
				row = rowIterator.next();
				
				String startPosNm = row.getCell(7).getStringCellValue();			// 출발지 항목 데이터
				String customerPhoneNumber = row.getCell(6).getStringCellValue();	// 고객전화 항목 데이터

				if (customerPhoneNumber.equals("N/A")) {	// 고객전화 항목 데이터가 N/A일 경우 오류항목으로 처리
					tempArr.put("startPosNm", startPosNm);
					tempArr.put("paymentTypeCd", "오류");
					tempArr.put("analysisResultCd", "오류");
					
				} else {
//					String startPosNm = row.getCell(7).getStringCellValue();
					String paymentTypeCd = getPaymentType(startPosNm);
					
					tempArr.put("startPosNm", startPosNm);
					tempArr.put("analysisResultCd", "정상(임시)");			// 추가 항목
					tempArr.put("paymentTypeCd", paymentTypeCd);

//					System.out.println(">> paymentTypeCd : " + paymentTypeCd + ", paymentType : " + paymentTypeArr[Integer.parseInt(paymentTypeCd)] + "\t\t|startPosNm : " + startPosNm);
					tempArr.put("paymentType", paymentTypeArr[Integer.parseInt(paymentTypeCd)]);
					
				}

				excelList.add(tempArr);
//				break;
			}
			
			return excelList;
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;

		}
		
		
	}


	/**
	 * 결제내역 방법 파악하는 메서드
	 * @author dhkim
	 * @param startPosNm
	 * @return
	 */
	public String getPaymentType(String startPosNm) {
		String returnPaymentTypeCd = "";
		String returnPaymentType = "";
		String findValue = ")";

		int basicIndex = startPosNm.indexOf(findValue);
		String[] paymentTypeArr = {"", "현금", "카드", "마일리지(전부)", "마일리지(일부사용)", "지원금"};
		
		if (basicIndex > -1) {
			// ")" 항목 존재함
			int lastIndex = startPosNm.length() - 1;
			String availableText = startPosNm.substring(0, basicIndex);

			if (basicIndex != lastIndex) {

				if (isTextContainCardKeyword(availableText)) {
					if (!isTextContainMileageKeyword(availableText)) {	// 
						returnPaymentType = paymentTypeArr[2];	// 카드
						returnPaymentTypeCd = "02";
						
					} else {
						if (isTextContainUseType(availableText)) {			// 마일리지 일부 사용
							returnPaymentType = paymentTypeArr[4];
							returnPaymentTypeCd = "04";
							
						} else {											// 마일리지 전부 사용
							returnPaymentType = paymentTypeArr[3];
							returnPaymentTypeCd = "03";
						}
					}

				} else {
					if (isTextContainMileageKeyword(availableText)) {
						if (isTextContainUseType(availableText)) {			// 마일리지 일부 사용
							returnPaymentType = paymentTypeArr[4];
							returnPaymentTypeCd = "04";
							
						} else {											// 마일리지 전부 사용
							returnPaymentType = paymentTypeArr[3];
							returnPaymentTypeCd = "03";
							
						}
					} else {
						if (isTextContainUseType(availableText)) {			// 지원금 사용
							returnPaymentType = paymentTypeArr[5];
							returnPaymentTypeCd = "05";
							
						} else {
							returnPaymentType = paymentTypeArr[1];			// 현금
							returnPaymentTypeCd = "01";
						}
					}

				}
				
			} else {	// ")" 는 존재하나 해당 위치가 데이터 맨 마지막일 경우 ex : 개포1231-4(라이브존(2/2)
				returnPaymentType = paymentTypeArr[1];						// 현금
				returnPaymentTypeCd = "01";
			}
			
		} else {
			// ")" 항목 존재 안함 == 현금으로 인식
			// "/" 항목, "]" 항목이 들어간 데이터는 샘플데이터상으로 모두 N/A 이므로 별도 분기처리 X
			returnPaymentType = paymentTypeArr[1];							// 현금
			returnPaymentTypeCd = "01";
			
		}
		
		return returnPaymentTypeCd;
		
	}
	
	
	
	/**
	 * 카드라는 단어가 존재하면 true, 존재하지 않으면 false
	 * @author dhkim
	 * @param availableText
	 * @return
	 */
	public boolean isTextContainCardKeyword(String availableText) {
		boolean returnFlag = false;
		if (availableText.contains("카드")) {
			returnFlag = true;
		}
		
		return returnFlag;
	}
	
	
	/**
	 * 마일, 마, 마일리지 라는 단어가 존재하면 true, 존재하지 않으면 false
	 * @author dhkim
	 * @param availableText
	 * @return
	 */
	public boolean isTextContainMileageKeyword(String availableText) {
		boolean returnFlag = false;
		if (availableText.contains("마일리지") || availableText.contains("마일") || availableText.contains("마")) {
			returnFlag = true;
		}

		return returnFlag;
	}


	/**
	 * 일부, k, K, 천후, 만후 등 단어가 존재할 경우 true, 존재하지 않으면 false
	 * @author dhkim
	 * @param availableText
	 * @return
	 */
	public boolean isTextContainUseType(String availableText) {
		boolean returnFlag = false;
		if (availableText.contains("일부") || availableText.contains("k") || availableText.contains("K") || availableText.contains("천후") || availableText.contains("만후")) {
			returnFlag = true;
		}
		
		return returnFlag;
	}

}
