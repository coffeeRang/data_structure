package doje.dh.map.myhashmap.day0913;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

import doje.dh.map.util.MyArrayList;

import java.util.Set;

public class MyHashMapByDh<K, V> {

	private MyArrayList<MyArrayList<MyEntry<K, V>>> mList = new MyArrayList<MyArrayList<MyEntry<K, V>>>();
	private MyArrayList<Integer> remainderKeyList = new MyArrayList<Integer>();
	private int devideHashNo = 0;
	
	private int size = mList.size();
	
	// inner class MyEntry
	public class MyEntry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;

		// 생성자
		public MyEntry() {}	// 테스트중
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
	 * MyHashMapByDh 생성자
	 */
	public MyHashMapByDh() {
		this.devideHashNo = 3;
		makeListToUseHash(devideHashNo);
	}
	public MyHashMapByDh(int size) {
		this.devideHashNo = 3;
		makeListToUseHash(devideHashNo);
	}



	// method ---------------------------------------------------

	/**
	 * key값 null check 하는 메서드
	 * @param key
	 * @throws NullPointerException
	 */
	public void checkNullValueOfKey(K key) throws NullPointerException{
		if (key == null) {
			throw new NullPointerException("key값에 null은 입력할 수 없습니다.");
		}
	}

	
	/**
	 * hashMap을 만들기 위한 내부 MyArrayList 생성하는 메서드
	 * @param size
	 */
	public void makeListToUseHash(int size) {
		mList = new MyArrayList<MyArrayList<MyEntry<K, V>>>();
		devideHashNo = size;
		remainderKeyList.clear();	// 초기화
		for (int i = 0; i < size; i++) {
			mList.add( new MyArrayList<MyEntry<K, V>>() );
			remainderKeyList.add(i);
		}
		this.size = getSumeOfInnerListSize();
	}


	/**
	 * devideHashNo 에 따른 listIndex 조회
	 * listIndex : key값 hashCode 로 변환뒤 devideHashNo으로 나눈 나머지 값 
	 * @param v
	 * @return
	 */
	public int getListIndexByKey(K key) {
		checkNullValueOfKey(key);
		int hashCode = key.hashCode();
		return hashCode % devideHashNo;
	}


	/**
	 * list에서 key값에 해당하는 index 조회하는 함수
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public int findIndexByKey(K key) {
		checkNullValueOfKey(key);
		int index = -1;
		int listIndex = getListIndexByKey(key);
		
		for (int i = 0; i < mList.get(listIndex).size(); i++) {
			K mapKey = (K) mList.get(listIndex).get(i).getKey();
			if (key.equals(mapKey)) {
				index = i;
				break;
			}
		}
		return index;
	}


	/**
	 * 특정 값을 포함한 index 갯수 조회 - 수정중_20180911_김동혁
	 * @author dhkim
	 * @param value
	 * @return
	 */
	public int getIndexCountByValue(V value) {
		int findCount = 0;

		for (int i = 0; i < mList.size(); i++) {
			for (int j = 0; j < mList.get(i).size(); j++) {
				V tempValue = mList.get(i).get(j).getValue();
				if (tempValue.equals(value)) {
					findCount++;
					break;
				}
			}
			
		}
		return findCount;
	}
	
	
	public int getSumeOfInnerListSize() {
		int sumSize = 0;
		for (int i = 0; i < remainderKeyList.size(); i++) {
			sumSize += mList.get(i).size();
		}
		return sumSize;
	}


	public boolean checkInnerListSize() {
		boolean checkFlag = false;
//		int minSize = Integer.MIN_VALUE;
//		int maxSize = Integer.MAX_VALUE;
		int minSize = Integer.MAX_VALUE;
		int maxSize = Integer.MIN_VALUE;
		
		for (int i = 0; i < mList.size(); i++) {
			int innerListSize = mList.get(i).size();
			if (innerListSize < minSize) {
				minSize = innerListSize;
			}
			if (innerListSize > maxSize) {
				maxSize = innerListSize;
			}
		}

		if (maxSize != 0 && minSize != 0 && maxSize >= minSize*2) {
			checkFlag = true;
		}
		
		return checkFlag;
		
	}

	/**
	 * key값으로 map에 들어있는 entry의 value 값을 가져오는 메서드
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public V put(K key, V value) {
		checkNullValueOfKey(key);
		V previousValue = null;
		boolean flag = false;	// true : maxSize >= minSize*2 를 의미한다.
		System.out.println(">> put 하려는 값 key : " + key + ", value : " + value);
//		System.out.println(">>>>>> put 이전 : (0)size: " + mList.get(0).size() + " | (1)size: " + mList.get(1).size() + " | (2)size: " + mList.get(2).size() + ", total_size: " + size);
		if (size > 0) {	// 0보다 크다면 maxSize, minSize 비교 필요
			// maxSize >= minSize * 2 일 경우 innerList 새로 만듬
			flag = checkInnerListSize();
		}
		
		if (flag) {	// innerList 재생성하고 값 재분배하기
			System.out.println("re defined start!!!!!!!!!!!!!!!!!!!!!!");
			// 기존 나눠져있던 데이터 한 arrayList로 담기
			MyArrayList<Entry<K, V>> tempList = new MyArrayList<Entry<K, V>>();
			for (int i= 0; i < mList.size(); i++) {
				for (int j = 0; j < mList.get(i).size(); j++) {
					Entry<K, V> entry = mList.get(i).get(j);
					tempList.add(entry);
				}
			}
			
			// 재생성 로직 실행
			makeListToUseHash(mList.size() * 2); // 개발중 미테스트);

			// tempList에 임시 보관한 데이터를 새로 생성된 mList에 할당
			for (int i = 0; i < tempList.size(); i++) {
				K tempKey = tempList.get(i).getKey();
				V tempValue = tempList.get(i).getValue();
				
				int listIndex = getListIndexByKey(tempKey);	// key값에 따른  devideHashNo의 listIndex 조회
				
				MyEntry<K, V> newEntry = new MyEntry<K, V>(tempKey, tempValue);
				mList.get(listIndex).add(newEntry);
			}
		}

		// 일반 put 처리
		int listIndex = getListIndexByKey(key);	// key값에 따른  devideHashNo의 listIndex 조회
		int entryIndex = findIndexByKey(key);	// key값에 따른 inner list의 Entry가 담긴 entryIndex 조회 
		
		if (-1 < entryIndex) {
			// 덮어쓰기
			previousValue = (V) mList.get(listIndex).get(entryIndex).getValue();
			mList.get(listIndex).get(entryIndex).setValue(value);
			
		} else {
			MyEntry<K, V> newEntry = new MyEntry<K, V>(key, value);
			mList.get(listIndex).add(newEntry);
			
//			size = getSumeOfInnerListSize();
			
		}
		
		size = getSumeOfInnerListSize();
		
		return previousValue;
	}


	/**
	 * map에 entry의 value를 가져오는 get method
	 * @author dhkim
	 * @param key
	 * @param value
	 * @return
	 */
	public V get(Object key) {
		V returnValue = null;
		int listIndex = getListIndexByKey((K) key);
		int entryIndex = findIndexByKey((K) key);
		
		if (entryIndex > -1) {
			returnValue = (V) mList.get(listIndex).get(entryIndex).getValue();
		}
		
		return returnValue;
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
	 * MyMap에 특정 값이 있을경우 return true - 수정중_20180911
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
		int listIndex = getListIndexByKey((K) key);
		int entryIndex = findIndexByKey((K) key);

		if (entryIndex > -1) {
			previousValue = mList.get(listIndex).get(entryIndex).getValue();
			mList.get(listIndex).remove(entryIndex);
			size = getSumeOfInnerListSize();
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
	 * value 값 list 에 담아서 return	-- 주소값으로만 표출됨(value 값으로 표출되게 변경 필요)
	 * 현재 MyArrayList 가 List를 implements 받은 clss 가 아니라 Collection 캐스팅 불가능
	 * 현재 개발중에는 values 리턴시 MyArrayList 로 return 하기로 정의
	 * @author dhkim
	 * @return
	 */
	public MyArrayList<V> values() {
		MyArrayList<V> tempList = new MyArrayList<V>();
		for (int i = 0; i < mList.size(); i++) {
			for (int j = 0; j < mList.get(i).size(); j++) {
				V value = mList.get(i).get(j).getValue();
				tempList.add(value);
			}
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
			for (int j = 0; j < mList.get(i).size(); j++) {
				K key = mList.get(i).get(j).getKey();
				keys.add(key);
			}
		}
		return keys;
	}
	

}
