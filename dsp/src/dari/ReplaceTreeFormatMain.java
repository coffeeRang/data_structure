package dari;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceTreeFormatMain {
	
//	public static void main(String[] args) {
//		HashMap<String, Object> replaceMap = new HashMap<String, Object>();
//		
//		
//		List<Map<String, Object>> infoList = new ArrayList<Map<String, Object>>();
//		HashMap<String, Object> rootInfo = new HashMap<String, Object>();
//		
//		for (int i = 0; i < infoList.size(); i++) {
//			HashMap<String, Object> info = (HashMap<String, Object>)infoList.get(i);
//			info.put("subInfo", "");
//			
//			
//			
//		}
//	}
	
	public void replaceFormat(List<HashMap<String, Object>> params) {
		String rootId = "10000";
		
		HashMap<String, Object> tempInfoMap = new HashMap<String, Object>();
		HashMap<String, Object> rootInfo = new HashMap<String, Object>();
		
		for (int i = 0; i < params.size(); i++) {
			HashMap<String, Object> infoMap = params.get(i);
			HashMap<String, Object> subInfoMap = new HashMap<String, Object>();
			infoMap.put("subInfoMap", subInfoMap);
			
			tempInfoMap.put((String)infoMap.get("menuId"), infoMap);
			
			
			if (infoMap.get("menuId").equals(rootId)) {
				rootInfo = infoMap;
			} else {
				HashMap<String, Object> parentInfoMap = new HashMap<String, Object>();
				if (i == 0) {
					rootInfo = infoMap;
				} else {
					parentInfoMap = (HashMap<String, Object>) tempInfoMap.get((String)infoMap.get("upperMenuId"));
//					parentInfoMap.get("subInfoMap").
				}
			}
			
			
		}
		
		
	}

}
