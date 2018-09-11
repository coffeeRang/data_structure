package doje.dh.mymap;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import doje.dh.mymap.MyArrayList;

public class MyGenericMapByDh<K, V> implements Map<K, V> {

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
			V tempValue = this.value;
			this.value = value;
			return tempValue;
		}
		
		@Override
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
	@Override
	public V get(Object key) {
		V returnValue = null;
		int index = findIndexByKey((K) key);
		if (index > -1) {
			returnValue = (V) mList.get(index).getValue();
		}
		
		return returnValue;
	}
	
	
	/**
	 * key에 해당하는 index 조회
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
	

	@Override
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
	 */
	@Override
	public boolean containsKey(Object key) {
		int index = findIndexByKey((K) key);
		return index > -1? true: false; 
	}

	/**
	 * 특정 값을 포함한 index 갯수 조회
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
	 * MyMap에 특정 값이 있을경우 return true
	 */
	@Override
	public boolean containsValue(Object value) {
		boolean returnFlag = false;
		if (0 < getIndexCountByValue((V) value)) {
			returnFlag = true;
		}
		return returnFlag;
	}


	/**
	 * MyMap에 값이 없으면 true, 있으면 false
	 */
	@Override
	public boolean isEmpty() {	
		return mList.size() == 0? true: false;
	}


	@Override
	public int size() {
		return size;
	}


	@Override
	public void clear() {
		mList.clear();
		size = mList.size();

	}


	@Override
	public V remove(Object key) {
		V previousValue = null;
		int index = findIndexByKey((K) key);

		if (index > -1) {
			previousValue = mList.get(index).getValue();
			mList.remove(index);
			size = mList.size();
		}
//		size = mList.size();
		return previousValue;
	}


	/**
	 * 다른 Map에 있는 값을 현재 MyMap에 넣어주는 메서드
	 */
	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
//		System.out.println(">> putAll method에 입력받은 parameter m : " + m);
		Set<K> setKey = (Set<K>) m.keySet();
		for (K key: setKey) {
			put(key, m.get(key));
		}
	}
	
	
	@Override
	public Collection<V> values() {
		MyArrayList<String> list = new MyArrayList<String>();

//		return (Collection<V>) list;
		return null;
	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> entrySet = new LinkedHashSet<Entry<K, V>>();
		Set<K> keys = keySet();

		for (K key: keys) {
			MyEntry<K, V> newEntry = new MyEntry<K, V>(key, get(key));
			entrySet.add(newEntry);
		}
		return entrySet;
	}
	
	
	@Override
	public Set<K> keySet() {
		Set<K> keys = new LinkedHashSet<K>();
		for (int i = 0; i < mList.size(); i++) {
			keys.add(mList.get(i).getKey());
		}
		return keys;
	}
	

}
