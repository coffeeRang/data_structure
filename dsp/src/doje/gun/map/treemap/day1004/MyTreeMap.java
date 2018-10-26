package doje.gun.map.treemap.day1004;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MyTreeMap<K, V> {
	private Node first;
	private int size;

	public MyTreeMap() {
		first = null;
		size = 0;
	}

	public void view() {
		System.out.println("====1====");
		System.out.println(first.key.hashCode());

		System.out.println("====2====");
		System.out.println(first.left.key.hashCode());

		System.out.println("====3====");
		System.out.println(first.left.left.key.hashCode() + " , " + first.left.right.key.hashCode());
	}

	private class Node implements Comparable<K>, Map.Entry<K, V> {
		private Node right;
		private Node left;

		private K key;
		private V value;

		public Node(K key, V value) {
			this.right = null;
			this.left = null;
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

		public Node getRight() {
			return this.right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return this.left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setKey(K key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return "KEY:" + key + " VALUE:" + value;
		}

		@Override
		public int compareTo(K key) {
			if (this.key.hashCode() > key.hashCode()) {
				return -1;
			} else if (this.key.hashCode() < key.hashCode()) {
				return 1;
			} else {
				return 0;
			}
		}
	}

	/**
	 * @param key
	 * @param value
	 * @author kimgun
	 * @return
	 */
	public V put(K key, V value) {
		Node node = new Node(key, value);
		if (first == null) {
			this.first = node;
		} else {
			Node firstTemp = first;
			Node temp = null;
			int result = 0;
			while (firstTemp != null) {
				result = firstTemp.compareTo(key);

				temp = firstTemp;
				if (result > 0) {
					firstTemp = firstTemp.right;
				} else if (result < 0) {
					firstTemp = firstTemp.left;
				} else {
					return firstTemp.setValue(value);
				}
			}
			if (result < 0)
				temp.left = node;
			else {
				temp.right = node;
			}
		}
		size++;
		return null;
	}

	public V get(Object key) {
		Node firstTemp = first;
		Node temp = null;
		int result = 0;
		while (firstTemp != null) {
			result = firstTemp.compareTo((K) key);

			if (result > 0) {
				firstTemp = firstTemp.right;
			} else if (result < 0) {
				firstTemp = firstTemp.left;
			} else {
				return firstTemp.value;
			}
		}
		return null;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	public boolean containsKey(Object key) {
		if (this.get((K) key) != null) {
			return true;
		}
		return false;
	}

	public boolean containsValue(Object value) {
		return false;
	}

	public V remove(Object key) {
		Node firstTemp = first;
		int result = 0;

		while (firstTemp != null) {
			result = firstTemp.compareTo((K) key);

		}
		size--;
		return null;
	}

	public void putAll(Map<K, V> m) {
		Set<Entry<K, V>> set = m.entrySet();

		for (Entry<K, V> ety : set) {
			this.put(ety.getKey(), ety.getValue());
		}
	}

	public void clear() {
		first = null;
		size = 0;
	}

	public Set<K> keySet() {
		return null;
	}

	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}
}
