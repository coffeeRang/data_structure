package doje.dh.map.util;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import doje.dh.map.util.MyArrayList;


public class MyLinearMap<K, V> {

	private MyArrayList<Entry<K, V>> list;	// key와 value를 가지고 있는 Entry를 담기 위한 list
	private int size;						// 배열 사이즈

	/**
	 * 생성자
	 * @author dhkim
	 */
	public MyLinearMap() {
		list = new MyArrayList<Entry<K, V>>();
		size = 0;
	}

	/**
	 * key와value를 가지고 있는 이너 클래스
	 * @author dhkim
	 * @param <K> Key
	 * @param <V> Value
	 */
	public class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;

		public Entry(K key, V value) {
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
			V oldV = this.value;
			this.value = value;
			return oldV;
		}

		@Override
		public String toString() {
			return key + "=" + value;
		}
	}

	/**
	 * 넘어온 파라미터의 null check
	 * @author dhkim
	 * @param key null체크를 하고자 하는 변수
	 */
	private void nullCheck(K key) {
		if (key == null) {
			throw new NullPointerException("널이 들어올 수 없습니다.");
		}
	}


	/**
	 * key값에 해당하는 Entry 반환하는 메서드
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public Entry<K, V> getEntryByKey(K key) {
		for (int i = 0; i < list.size(); i++) {
			Entry<K, V> entry = list.get(i);
			if (entry.getKey().equals(key)) {
				System.out.println("myLinearMap size : " + size);
				return entry;
			}
		}
		return null;
	}

	/**
	 * index에 해당하는 Entry 반환하는 메서드
	 * @author dhkim
	 * @param index
	 * @return
	 */
	public Entry<K, V> getEntryByIndex(int index) {
		System.out.println("myLinearMap size : " + size);

		return null;
//		System.out.println(list.get(0).getValue());
		
		
//		Entry<K, V> entry = list.get(index);
//		return entry;
//		return list.get(index);
		
	}


	/**
	 * 해당 key의 인덱스를 반환해줌.
	 * @author dhkim
	 * @param key 찾고자 하는 인덱스를 나타내는 변수
	 * @return 인덱스를 반환해준다.
	 */
	private int getKeyIndex(K key) {
		nullCheck(key);
		int idx = -1;
		for (int i = 0; i < size; i++) {
			if (list.get(i).getKey().equals(key)) {
				idx = i;
			}
		}
		return idx;
	}

	/**
	 * 해당 키의 value를 반환해준다.
	 * @author dhkim
	 * @param key value를 찾고자 하는 key의 값
	 * @return 넘어온 key의 value
	 */
	private V getValue(K key) {
		nullCheck(key);
		V value = null;
		for (int i = 0; i < size; i++) {
			if (list.get(i).getKey().equals(key)) {
				value = list.get(i).getValue();
			}
		}
		return value;
	}

	/**
	 * 값을 추가해준다.
	 * @author dhkim
	 * @param key 값의 키
	 * @param value 키에 매칭되는 값
	 * @return 만약, 추가할 키와 같은 키가 이미 있으면 원래 키에 있던 값을 반환해주고, 아니면 null을 반환해준다.
	 */
	public V put(K key, V value) {
		nullCheck(key);

		V returnV = null;
		int idx = getKeyIndex(key);

		Entry<K, V> ety = null;
		if (idx > -1) {
			ety = list.get(idx);
			returnV = (V) ety.getValue();
			ety.setValue(value);
		} else {
			ety = new Entry<K, V>(key, value);
			list.add(ety);
			size++;
		}
		return returnV;
	}

	/**
	 * key 값에 해당하는 Value 를 return 하는 메서드
	 * @author dhkim
	 * @param key 찾고자 하는 value의 key
	 * @return key의 매칭되는 value를 반환해준다.
	 */
	public V get(Object key) {
		nullCheck((K) key);
		return getValue((K) key);
	}

	/**
	 * map이 담긴 size return 하는 메서드
	 * @author dhkim
	 * @return size
	 */
	public int size() {
		return this.size;
	}

	/**
	 * 배열 size 확인하는 메서드
	 * @author dhkim
	 * @return size가 0이면 true를, 아니면 false를 반환해준다.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 입력받은 key값을 가진 map entry 존재 확인하는 메서드
	 * @author dhkim
	 * @param key 같은 값이 있는 지 판단하기 위함
	 * @return 있으면 true, 없으면 false
	 */
	public boolean containsKey(Object key) {
		return getKeyIndex((K) key) > -1;
	}

	/**
	 * 넘어온 value와 같은 값이 있는지 판단한다.
	 * @author dhkim
	 * @param value value와 같은 값이 있는 지 판단하기 위함 
	 * @return 있으면 true, 없으면 false
	 */
	public boolean containsValue(Object value) {
		for (int i = 0; i < size; i++) {
			if (list.get(i).getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 입력받은 key에 해당하는 값을 삭제하는 메서드
	 * @author dhkim
	 * @param key 삭제할 엔트리의 key
	 * @return 삭제가 되면 삭제한 엔트리의 value를, 아니면 null을 반환한다.
	 */
	public V remove(K key) {
		nullCheck(key);

		V remove = null;

		int idx = getKeyIndex(key);
		if (idx > -1) {
			V temp = list.get(idx).getValue();
			list.remove(idx);
			remove = temp;
		}
		size--;
		return remove;
	}

	/**
	 * 입력받은 map에 들어있는 entry를 기존 map이 추가하는 메서드
	 * @author dhkim
	 * @param m 추가할 리스트
	 */
	private void putAll(Map<K, V> m) {
		Set<K> keys = m.keySet();

		for (K key : keys) {
			put(key, m.get(key));
		}
	}

	/**
	 * map에 있는 모든 entry를 반환하는 메서드
	 * @author dhkim
	 * @return 엔트리를 반환
	 */
	private Set<Entry<K, V>> entrySet() {
		Set<K> keys = keySet();

		Set<Entry<K, V>> entry = new LinkedHashSet<Entry<K, V>>();
		for (K key : keys) {
			entry.add(new Entry(key, get(key)));
		}

		return entry;
	}

	/**
	 * Set에 entry의 모든 key값을 return 하는 메서드
	 * @author dhkim
	 * @return keys 배열 안에 모든 key를 반환
	 */
	public Set<K> keySet() {
		Set<K> keys = new LinkedHashSet<K>();

		for (int i = 0; i < size; i++) {
			keys.add(list.get(i).getKey());
		}
		return keys;
	}

	/**
	 * 배열 안에 요소들을 모두 비우는 메서드
	 * @author dhkim
	 */
	public void clear() {
		size = 0;
		list = new MyArrayList<Entry<K, V>>();
	}
}
