package doje.dh.map.mymap.day0911;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

import doje.dh.map.util.MyArrayList;

import java.util.Set;

public class MyGenericMapByDh<K, V> {

	private MyArrayList<MyEntry<K, V>> mList = new MyArrayList<MyEntry<K, V>>();
	private int size = mList.size();

	// inner class MyEntry
	public class MyEntry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;

		// 생성자
		public MyEntry() {} // 사용 안함 (테스트 중)
		public MyEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		
		public K getKey() {
			return this.key;
		}

		
		public V getValue() {
			return this.value;
		}

		
		public V setValue(V value) {
			V tempValue = this.value;
			this.value = value;
			return tempValue;
		}
		
		
		public String toString() {
			return key + "=" + value; 
			
		}

	}

	/**
	 * MyGenericMapByDh 생성자
	 */
	public MyGenericMapByDh() {}
	public MyGenericMapByDh(K key, V value) {
		put(key, value);
	}

	
	// method ---------------------------------------------------
	/**
	 * list에서 key값에 해당하는 index 조회하는 함수
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public int findIndexByKey(K key) {
		int index = -1;
		for (int i = 0; i < mList.size(); i++) {
			K mapKey = (K) mList.get(i).getKey();
			if (key.equals(mapKey)) {
				index = i;
				break;
			}
		}
		return index;
	}


	/**
	 * 특정 값을 포함한 index 갯수 조회
	 * @author dhkim
	 * @param value
	 * @return
	 */
	public int getIndexCountByValue(V value) {
		int findCount = 0;
		for (int i = 0; i < mList.size(); i++) {
			V tempValue = mList.get(i).getValue();
			if (value.equals(tempValue)) {
				findCount += 1;
			}
		}
		return findCount;
	}
	
	/**
	 * map에 entry 를 추가하는 put method
	 * @author dhkim
	 * @param key
	 * @param value
	 * @return
	 */
	public V get(Object key) {
		V returnValue = null;
		int index = findIndexByKey((K) key);
		if (index > -1) {
			returnValue = (V) mList.get(index).getValue();
		}
		
		return returnValue;
	}


	/**
	 * key값으로 map에 들어있는 entry의 value 값을 가져오는 메서드
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public V put(K key, V value) {
		V previousValue = null;		
		int index = findIndexByKey(key);

		if (index > -1) {	// 동일 key가 map에 있을경우 덮어쓰기
			previousValue = (V) mList.get(index).getValue();
			mList.get(index).setValue(value);

		} else {	// 없을경우 신규로 add
			MyEntry<K, V> newEntry = new MyEntry<K, V>(key, value);
			mList.add(newEntry);
			size = mList.size();
		}
		
		return previousValue;
	}


	/**
	 * MyMap에서 key 값 갖고 있을 경우 true 리턴하는 메서드
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public boolean containsKey(Object key) {
		int index = findIndexByKey((K) key);
		return index > -1? true: false; 
	}


	/**
	 * MyMap에 특정 값이 있을경우 return true
	 * @param value
	 * @return
	 */
	public boolean containsValue(Object value) {
		boolean returnFlag = false;
		if (0 < getIndexCountByValue((V) value)) {
			returnFlag = true;
		}
		return returnFlag;
	}


	/**
	 * MyMap에 값이 없으면 true, 있으면 false
	 * @return
	 */
	public boolean isEmpty() {	
		return mList.size() == 0? true: false;
	}


	/**
	 * 현재 map이 담긴 MyArrayList 사이즈 조회
	 * @return
	 */
	public int size() {
		return size;
	}


	/**
	 * map 초기화
	 */
	public void clear() {
		mList.clear();
		size = mList.size();
	}


	/**
	 * 입력받은 key 값에 해당하는 map의 entry를 삭제하는 메서드
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public V remove(Object key) {
		V previousValue = null;
		int index = findIndexByKey((K) key);

		if (index > -1) {
			previousValue = mList.get(index).getValue();
			mList.remove(index);
			size = mList.size();
		}
		return previousValue;
	}


	/**
	 * 다른 Map에 있는 값을 현재 MyMap에 넣어주는 메서드
	 * @author dhkim
	 * @param m
	 */
	public void putAll(Map<? extends K, ? extends V> m) {
		Set<K> setKey = (Set<K>) m.keySet();
		for (K key: setKey) {
			put(key, m.get(key));
		}
	}
	
	
	/**
	 * value 값 list 에 담아서 return
	 * 현재 MyArrayList 가 List를 implements 받은 clss 가 아니라 Collection 캐스팅 불가능
	 * 현재 개발중에는 values 리턴시 MyArrayList 로 return 하기로 정의
	 * @author dhkim
	 * @return
	 */
	public MyArrayList<V> values() {
		MyArrayList<V> tempList = new MyArrayList<V>();
		for (int i = 0; i < mList.size(); i++) {
			tempList.add(mList.get(i).getValue());
		}
		return tempList;
	}
	

	/**
	 * entry를 담은 Set 으로 return 하는 메서드
	 * @author dhkim
	 * @return
	 */
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> entrySet = new LinkedHashSet<Entry<K, V>>();
		Set<K> keys = keySet();

		for (K key: keys) {
			MyEntry<K, V> newEntry = new MyEntry<K, V>(key, get(key));
			entrySet.add(newEntry);
		}
		return entrySet;
	}
	
	
	/**
	 * map의 key값을 Set으로 담아 return 하는 메서드
	 * @author dhkim
	 * @return
	 */
	public Set<K> keySet() {
		Set<K> keys = new LinkedHashSet<K>();
		for (int i = 0; i < mList.size(); i++) {
			keys.add(mList.get(i).getKey());
		}
		return keys;
	}
	

}
