package doje.dh.map.treemap.day0927;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

import doje.dh.map.mymap.day0911.MyGenericMapByDh.MyEntry;
import doje.dh.map.util.MyArrayList;

import java.util.Set;

public class MyTreeMap2<K, V, T> {
	
	private MyArrayList<Node> mList;		// Node가 담길 mList
	private Node firstNode;					// 첫번째 Node
	private int size;						// 사이즈
	
	public MyTreeMap2() {
		mList = new MyArrayList<Node>();
		this.firstNode = null;
		this.size = 0;
	}
	
	public class Node implements Comparable<T>, Map.Entry<K, V> {
//		private Entry<K, V> entry;
		private K key;
		private V value;
		private Node leftNode;
		private Node rightNode;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		/**
		 * Map에 데이터를 입력시 compareTo메서드를 어떻게 활용할건지 다시 생각해보기
		 */
		@Override
		public int compareTo(T arg0) {
			int resultOfCompare = 0;
			if(arg0 instanceof String) {
				
			}else if(arg0 instanceof Integer) {
				
			}
			return resultOfCompare;
		}
		
		@Override
		public String toString() {
			return key + "=" + value; 
			
		}
	}

	
	
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
	 * key값에 해당하는 value TreeMap node에 넣는 메서드
	 * @author dhkim
	 * @param key
	 * @param value
	 * @return
	 */
	public V put(K key, V value) {
		V previousValue = null;
		int index = findIndexByKey(key);
		if (index > -1) {	// 동일 key가 존재할경우 덮어쓰기
			mList.get(index).setValue(value);
		} else {	// index가 없을경우 신규로 추가
			Node node = new Node(key, value);
			if (firstNode == null) {
				firstNode = node;
				mList.add(firstNode);
			} else {
				mList.add(node);
			}
		}
		return previousValue;
	}
	
	/**
	 * key값에 해당하는 TreeMap node value 조회
	 * @author dhkim
	 * @param key
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
	 * Node에 해당 key 값 존재여부 확인
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public boolean containsKey(Object key) {
		int index = findIndexByKey((K) key);
		return index > -1? true: false;
	}

	/**
	 * 입력받은 value가 map에 존재하는지 확인하는 메서드
	 * @author dhkim
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
	 * entry를 담은 Set 으로 return 하는 메서드
	 * @author dhkim
	 * @return
	 */
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> entrySet = new LinkedHashSet<Entry<K, V>>();
		Set<K> keys = keySet();

		for (K key: keys) {
			Node newNode = new Node(key, this.get(key));
			entrySet.add(newNode);
		}
		return entrySet;
	}
	

	/**
	 * map size가 0인지 아닌지 확힌하는 메서드
	 * @author dhkim
	 * @return
	 */
	public boolean isEmpty() {
		return mList.size() == 0? true: false;
	}

	/**
	 * map의 key를 Set에 담아서 return 하는 메서드
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


	/**
	 * 다른 Map에 있는 값을 현재 map에 넣는 메서드
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
	 * 입력받은 key에 해당하는 value를 지우는 메서드
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
	 * map에 들어있는 값 갯수 조회하는 메서드
	 * @author dhkim
	 * @return
	 */
	public int size() {
		return size;
	}


	/**
	 * map 내 모든 정보를 비우는 메서드
	 * @author dhkim
	 */
	public void clear() {
		mList.clear();
		size = mList.size();
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

}
