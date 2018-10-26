package doje.gun.map.treemap.day1004_03;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author kimgun
 *
 * @param <K>
 * @param <V>
 */
public class MyTreeMap<K, V> {
	private Node first;
	private int size;

	public MyTreeMap() {
		this.first = null;
		this.size = 0;
	}

	/** key와 value를 관리하고 왼쪽 노드와 오른쪽 노드를 가지고 있음.
	 * @author kimgun
	 *
	 */
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
			return "KEY:" + this.key + " VALUE:" + this.value;
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

	/** 노드를 추가함.
	 * @param key
	 * @param value
	 * @author kimgun
	 * @return
	 */
	public V put(K key, V value) {
		Node node = new Node(key, value);
		if (this.first == null) {
			this.first = node;
		} else {
			Node firstTemp = this.first;
			Node temp = null;
			int result = 0;
			while (firstTemp != null) {
				result = firstTemp.compareTo(key);

				temp = firstTemp;
				if (result > 0) {
					firstTemp = firstTemp.getRight();
				} else if (result < 0) {
					firstTemp = firstTemp.getLeft();
				} else {
					return firstTemp.setValue(value);
				}
			}
			if (result < 0)
				temp.setLeft(node);
			else {
				temp.setRight(node);
			}
		}
		this.size++;
		return null;
	}

	/** 노드를 얻어옴.
	 * @param key
	 * @return
	 */
	public V get(Object key) {
		Node firstTemp = this.first;
		int result = 0;
		while (firstTemp != null) {
			result = firstTemp.compareTo((K) key);

			if (result > 0) {
				firstTemp = firstTemp.getRight();
			} else if (result < 0) {
				firstTemp = firstTemp.getLeft();
			} else {
				return firstTemp.getValue();
			}
		}
		return null;
	}

	/** size를 얻어옴.
	 * @return
	 */
	public int size() {
		return this.size;
	}

	/**배열이 비었는 지를 확인
	 * @return
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;
	}

	/**key가 존재하는 지 확인
	 * @param key
	 * @return
	 */
	public boolean containsKey(Object key) {
		if (this.get((K) key) != null) {
			return true;
		}
		return false;
	}

	public boolean containsValue(Object value) {
		return false;
	}

	/**노드를 삭제함.
	 * @param key
	 * @return
	 */
	public V remove(Object key) {
		Node removeNode = this.first;
		Node superNode = null;
		int result = 0;

		boolean isDirection = false;
		while (removeNode != null) {
			result = removeNode.compareTo((K) key);

			if (result > 0) {
				superNode = removeNode;
				removeNode = removeNode.getRight();
				isDirection = true;
			} else if (result < 0) {
				superNode = removeNode;
				removeNode = removeNode.getLeft();
				isDirection = false;
			} else {
				//삭제 처리
				Node temp = removeNode.getRight();
				if (removeNode.key.hashCode() == this.first.key.hashCode()) {
					if (removeNode.getRight() == null && removeNode.getLeft() == null) {
						this.first = null;
					} else if (removeNode.getRight() != null && removeNode.getLeft() == null) {
						this.first = this.first.getRight();
					} else if (removeNode.getRight() == null && removeNode.getLeft() != null) {
						this.first = this.first.getLeft();
					} else if (removeNode.getRight() != null && removeNode.getLeft() != null) {

						Node jogun = null;
						while (temp != null) {
							jogun = temp;
							temp = temp.getLeft();
						}
						jogun.setLeft(this.first.getLeft());
						this.first = this.first.getRight();
					}
				} else if (removeNode.getRight() != null && removeNode.getLeft() != null) {

					//삭제할 노드의 오른쪽 노드의 왼쪽 끝을 찾아줌
					Node jogun = null;
					while (temp != null) {
						jogun = temp;
						temp = temp.getLeft();
					}
					//삭제할 노드의 오른쪽 노드의 왼쪽 끝의 왼쪽에 삭제할 노드의 왼쪽을 넣어줌
					jogun.setLeft(removeNode.getLeft());

					if (isDirection) {
						superNode.setRight(removeNode.getRight());
					} else {
						superNode.setLeft(removeNode.getRight());
					}
				} else if (removeNode.getRight() == null && removeNode.getLeft() != null) {
					if (isDirection) {
						superNode.setRight(removeNode.getLeft());
					} else {
						superNode.setLeft(removeNode.getLeft());
					}
				} else if (removeNode.getRight() != null && removeNode.getLeft() == null) {
					if (isDirection) {
						superNode.setRight(removeNode.getRight());
					} else {
						superNode.setLeft(removeNode.getRight());
					}
				} else if (removeNode.getRight() == null && removeNode.getLeft() == null) {
					if (isDirection) {
						superNode.setRight(null);
					} else {
						superNode.setLeft(null);
					}
				}
				break;
			}
		}
		this.size--;
		return null;
	}

	/** 넘어온 컬렉션에 모든 노드를 추가
	 * @param m
	 */
	public void putAll(Map<K, V> m) {
		Set<Entry<K, V>> set = m.entrySet();

		for (Entry<K, V> ety : set) {
			this.put(ety.getKey(), ety.getValue());
		}
	}

	/**
	 * 배열을 비움.
	 */
	public void clear() {
		this.first = null;
		this.size = 0;
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
