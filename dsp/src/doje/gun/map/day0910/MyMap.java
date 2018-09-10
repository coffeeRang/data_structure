package doje.gun.map.day0910;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import doje.gun.map.day0910.MyArrayList;

public class MyMap<K, V> {

	private MyArrayList<Entry<K, V>> list;
	private int size;

	public MyMap() {
		list = new MyArrayList<Entry<K, V>>();
		size = 0;
	}

	private class Entry<K, V> implements Map.Entry<K, V> {
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

	}

	public V put(K key, V value) {
		for (int i = 0; i < size; i++) {
			if (list.get(i).getKey().equals(key)) {
				V temp = list.get(i).getValue();
				list.get(i).setValue(value);
				return temp;
			}
		}

		Entry ety = new Entry(key, value);
		list.add(ety);
		size++;
		return null;
	}

	public V get(Object key) {
		for (int i = 0; i < size; i++) {
			if (list.get(i).getKey().equals(key)) {
				return list.get(i).getValue();
			}
		}
		return null;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean containsKey(Object key) {
		for (int i = 0; i < size; i++) {
			if (list.get(i).getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsValue(Object value) {
		for (int i = 0; i < size; i++) {
			if (list.get(i).getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	public V remove(K key) {
		V remove = null;
		for (int i = 0; i < size; i++) {
			if (list.get(i).getKey().equals(key)) {
				V temp = list.get(i).getValue();
				list.remove(i);
				remove = temp;
			}
		}
		size--;
		return remove;
	}

	public void putAll(Map<K, V> m) {

	}

	public void clear() {
		size = 0;
		list = new MyArrayList<Entry<K, V>>();
	}
}
