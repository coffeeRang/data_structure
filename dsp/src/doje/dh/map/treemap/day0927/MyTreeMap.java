package doje.dh.map.treemap.day0927;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

import doje.dh.map.mymap.day0911.MyGenericMapByDh.MyEntry;
import doje.dh.map.util.MyArrayList;

import java.util.Set;

public class MyTreeMap<K, V> {
	
	private Node firstNode;					// 첫번째 Node
	private int size;						// 사이즈
	
	public MyTreeMap() {
		this.firstNode = null;
		this.size = 0;
	}
	
	public class Node implements Comparable<K>, Map.Entry<K, V> {
		private K key;
		private V value;
		private Node leftNode;
		private Node rightNode;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.leftNode = null;
			this.rightNode = null;
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
		public int compareTo(K arg0) {
			int resultNum = 0;
			int hashCode = arg0.hashCode();

			if (hashCode > key.hashCode()) {
				resultNum = 1;
				
			} else if (hashCode < key.hashCode()) {
				resultNum = -1;
				
			}
			return resultNum;
		}
		
		@Override
		public String toString() {
			return key + "=" + value; 
			
		}
	}

	
	
	/**
	 * key값에 해당하는 value TreeMap node에 넣는 메서드
	 * @author dhkim
	 * @param key
	 * @param value
	 * @return
	 */
	public V put(K key, V value) {
		Node startNode = firstNode;
		V previousValue = null;
		
		Node newNode = new Node(key, value);
		if (firstNode == null ) {
			firstNode = newNode;
		} else {
			while(startNode != null) {
				int index = startNode.compareTo(key);
				if (index > 0) {
					if (startNode.rightNode == null) {
						startNode.rightNode = newNode;
						break;
					} else {
						startNode = startNode.rightNode;
					}
					
				} else if (index < 0) {
					if (startNode.leftNode == null) {
						startNode.leftNode = newNode;
						break;
					} else {
						startNode = startNode.leftNode;
					}
				} else {
					previousValue = startNode.getValue();
					startNode.setValue(value);
					break;
				}

			}
		}
		size++;
		return previousValue;
	}
	
	/**
	 * key값에 해당하는 TreeMap node value 조회 - 테스트(작동함)
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public V get(Object key) {
		V returnValue = null;
		Node startNode = firstNode;

		while(startNode != null) {
			if (startNode.getKey().equals(key)) {
				returnValue = startNode.getValue();
				break;

			} else {
				int index = startNode.compareTo((K)key);

				if (index > 0) {
					startNode = startNode.rightNode;
				} else if (index < 0) {
					startNode = startNode.leftNode;
				}
			}
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
		boolean returnFlag = false;
		V v = this.get(key);
		if (v != null) {
			returnFlag = true;
		}
		return returnFlag;
	}

	

	/**
	 * value 찾기위해 별도생성 메서드
	 * @param value
	 * @return
	 */
	public V checkValueInNode(V value) {
		V returnValue = null;
		Node startNode = firstNode;

		while(startNode != null) {
			if (startNode.getValue().equals(value)) {
				returnValue = startNode.getValue();
				break;

			} else {
				int index = startNode.compareTo(startNode.getKey());

				if (index > 0) {
					startNode = startNode.rightNode;
				} else if (index < 0) {
					startNode = startNode.leftNode;
				} else {
					returnValue = startNode.getValue();
					break;
				}
			}
		}
		return returnValue;
	}

	
	/**
	 * 입력받은 value가 map에 존재하는지 확인하는 메서드
	 * @author dhkim
	 * @param value
	 * @return
	 */
	public boolean containsValue(Object value) {
		boolean returnFlag = false;
		
		V findValue = checkValueInNode((V)value);
		if (findValue != null) {
			returnFlag = true;
		}
	
		return returnFlag;
	}
	

	/**
	 * entry를 담은 Set 으로 return 하는 메서드
	 * @author dhkim
	 * @return
	 */
//	public Set<Entry<K, V>> entrySet() {
//		Set<Entry<K, V>> entrySet = new LinkedHashSet<Entry<K, V>>();
//		Set<K> keys = keySet();
//
//		for (K key: keys) {
//			Node newNode = new Node(key, this.get(key));
//			entrySet.add(newNode);
//		}
//		return entrySet;
//	}
	

	/**
	 * map size가 0인지 아닌지 확힌하는 메서드
	 * @author dhkim
	 * @return
	 */
	public boolean isEmpty() {
		return this.size() == 0? true: false;
	}

	/**
	 * map의 key를 Set에 담아서 return 하는 메서드
	 * @author dhkim
	 * @return
	 */
	public Set<K> keySet() {
		Set<K> keys = new LinkedHashSet<K>();
		Node startNode = firstNode;
		int temp = 0;
		while(startNode != null) {
			K key = null;
			if (startNode.getKey().equals(key)) {
				keys.add(key);
				break;

			} else {
				int index = startNode.compareTo(startNode.getKey());

				if (index > 0) {
					startNode = startNode.rightNode;
					keys.add(startNode.getKey());
				} else if (index < 0) {
					startNode = startNode.leftNode;
					keys.add(startNode.getKey());
				} else {
					key = startNode.getKey();
					break;
				}
			}
		}

		return keys;
	}


	/**
	 * 다른 Map에 있는 값을 현재 map에 넣는 메서드
	 * @author dhkim
	 * @param m
	 */
	public void putAll(Map<? extends K, ? extends V> m) {
//		Set<K> setKey = (Set<K>) m.keySet();
//		for (K key: setKey) {
//			put(key, m.get(key));
//		}
	}
	
	/**
	 * key값에 해당하는 Node return
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public Node getNodeByKey(K key) {
		Node returnNode = null;
		Node startNode = firstNode;

		while(startNode != null) {
			if (startNode.getKey().equals(key)) {
				returnNode = startNode;
				break;

			} else {
				int index = startNode.compareTo((K)key);
				if (index > 0) {
					startNode = startNode.rightNode;
				} else if (index < 0) {
					startNode = startNode.leftNode;
				}
			}
		}
		return returnNode;
	}
	
	
	/**
	 * 입력받은 key에 해당하는 value를 지우는 메서드
	 * @author dhkim
	 * @param key
	 * @return
	 */
	public V remove(Object key) {
		V previousValue = null;
		Node nodeByKey= getNodeByKey((K)key);
		nodeByKey.setValue(null);
//		if (nodeByKey == ) {
//			
//		}
		
		
//		int index = findIndexByKey((K) key);
		
//
//		if (index > -1) {
//			previousValue = mList.get(index).getValue();
//			mList.remove(index);
//			size = mList.size();
//		}
//		Node startNode = firstNode;
//
//		while(startNode != null) {
//			if (startNode.getKey().equals(key)) {
//				previousValue = startNode.getValue();
//				break;
//
//			} else {
//				int index = startNode.compareTo((K)key);
//
//				if (index > 0) {
//					startNode = startNode.rightNode;
//				} else if (index < 0) {
//					startNode = startNode.leftNode;
//				}
//			}
//		}
//		if (previousValue == null) {
//			startNode = null;
//		}
		
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
//	public void clear() {
//		mList.clear();
//		size = mList.size();
//	}
	
	
	/**
	 * value 값 list 에 담아서 return
	 * 현재 MyArrayList 가 List를 implements 받은 clss 가 아니라 Collection 캐스팅 불가능
	 * 현재 개발중에는 values 리턴시 MyArrayList 로 return 하기로 정의
	 * @author dhkim
	 * @return
	 */
//	public MyArrayList<V> values() {
//		MyArrayList<V> tempList = new MyArrayList<V>();
//		for (int i = 0; i < mList.size(); i++) {
//			tempList.add(mList.get(i).getValue());
//		}
//		return tempList;
//	}

}
