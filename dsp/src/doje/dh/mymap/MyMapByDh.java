package doje.dh.mymap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import doje.dh.mymap.MyArrayList;

public class MyMapByDh {
	private Entry newEntry = null;
	MyArrayList mList = new MyArrayList();
	
	public class Entry {
		public String key;
		public String value;
		public Entry(String key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public MyMapByDh(String key, String value) {
		newEntry = new Entry(key, value);
	}
	
	
	public String get(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String put(String key, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	
//	public Set<Entry<String, String>> entrySet() {
//		return null;
//	}

	
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

	
	public String remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<String> values() {
		// TODO Auto-generated method stub
		return null;
	}

}
