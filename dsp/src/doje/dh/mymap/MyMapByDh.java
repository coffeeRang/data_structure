package doje.dh.mymap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import doje.dh.mymap.MyArrayList;

public class MyMapByDh {
	public MyEntry entry = null;
	
	MyArrayList<MyEntry> mList = new MyArrayList<MyEntry>();
//	private int size = 0;
	private int size = mList.size();
	
	public class MyEntry {
		public String key;
		public String value;
		
		/**
		 * MyEntry 생성자
		 */
		public MyEntry() {}	// 사용 안함 (테스트 중)
		public MyEntry(String key, String value) {
			this.key = key;
			this.value = value;
		}

		public String getKey() {
			return this.key;
		}

		public String getValue() {
			return this.value;
		}

		public String setValue(String value) {
			String tempValue = this.value;
			this.value = value;
			return tempValue;
		}
	}
	
	/**
	 * MyMapByDh 생성자
	 */
	public MyMapByDh() {
//		entry = new MyEntry();	// 사용 안함
	}
	public MyMapByDh(String key, String value) {
		entry = new MyEntry(key, value);
	}


	/**
	 * mList에 담긴 MyEntry 에서 특정 key 값이 존재할경우 그 index 값 조회하는 메서드
	 * @param key
	 * @return
	 */
	public int findIndexByKey(String key) {
		int index = -1;
		for (int i = 0; i < mList.size(); i++) {
			String findResultKey = mList.get(i).getKey();
			if (key.equals(findResultKey)) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	
	/**
	 * mList에 담김 MyEntry 에서 key값에 해당하는 value 값 조회 하는 메서드
	 * @param key
	 * @return
	 */
	public String findValueByKey(String key) {
		String value = null;
		int index = findIndexByKey(key);
		if (index > -1) {
			value = mList.get(index).getValue();
		}

		return value;
	}

	
	/**
	 * key에 해당하는 value 값 조회해 return 하는 메서드
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public String get(String key) {
		return findValueByKey(key);
	}

	
	/**
	 * MyEntry에 key 값을 기준으로 value 값 할당하는 메서드
	 * @author dhkim 
	 * @param key
	 * @param value
	 * @return
	 */
	public String put(String key, String value) {
		MyEntry newEntry = new MyEntry(key, value);
		mList.add(newEntry);
		size = mList.size();
		return null;
	}

	
	/**
	 * MyMapByDh 초기화(값 비우기)
	 * @author dhkim
	 */
	public void clear() {
		for (int i = 0; i < mList.size(); i++) {
			mList.remove(i);
		}
		size = mList.size();
	}
	
	
	/**
	 * MyMap에서 특정 key 값에 해당하는 값 삭제
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public String remove(String key) {
		int i = findIndexByKey(key);
		String previousValue = null;
		if (-1 < i) {
			previousValue = mList.get(i).getValue();
			mList.remove(i);
			
		}
		return previousValue;
	}
	
	/**
	 * 현재 size 조회하는 메서드
	 * @author dhkim
	 * @return
	 */
	public int size() {
		return size;
	}
	

	/**
	 * 특정 key 값이 MyMap MyEntry에 존재하는지 여부 확인
	 * @param key
	 * @return
	 */
	public boolean containsKey(String key) {
		int index = findIndexByKey(key);
		if (index > -1) {
			return true;
			
		}
		return false;
	}

	
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void putAll(Map<? extends String, ? extends String> m) {
		// TODO Auto-generated method stub
		
	}

	


	
//	public Set<Entry<String, String>> entrySet() {
//		return null;
//	}
	
//	public Collection<String> values() {
//		return null;
//	}

}
