package doje.training.day1015;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestMain {
	
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		
		try {
			// 현재 class의 상대경로를 조회
			String path = TestMain.class.getResource("").getPath();

			// 해당 상대경로에 존재하는 indicat_db.json 파일을 읽어들인다.
			Object obj = parser.parse(new FileReader(path + "indicat_db.json"));

			JSONObject jsonObj = (JSONObject)obj;
			System.out.println(jsonObj.toString());
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
			
	}

}
