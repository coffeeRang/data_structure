package doje.sy.list.linkedlist.day0828;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *2018/08/27 ~ 2018/08/28
 * @author NamSangYuop
 */
public class MyLinkedList {
	int size;
	
	// 처음값
	Node first; 
	// 새로만든 노드값 null;
	Node last; 

	//초기화
	public MyLinkedList() {
		size = 0;
		first = null;
		last = null;

	}
	
	/**
	 * Node를 만들어 주기 위해 인어클래스를 만들었다.
	 * @author NamSangYuop
	 */
	public class Node {
		String data;
		Node next;
		
		//노드값 초기화
		public Node(String data) {
			this.data = data;
			next = null;
		}

	}
	// index값 체크
	private void checkBoundException(int index) {

		if (index <= 0 || index > size) {
			// 위치값이 0보다 작거나 사이즈값 보다 크거나 같으면 BoundsException을 띄운다.
			throw new IndexOutOfBoundsException("index값을 확인하세요.");
		}
	}
	/**
	 * 마지막 순번에 값을 추가
	 * @param str
	 * @author NamSangYuop
	 */
	public boolean add(String str) {
		Node nnd = new Node(str);

		if (size == 0) {
			nnd.next = first;
			first = nnd;
			last = nnd;
		} else {
			Node newnode = first;
			last.next = nnd;
			last = nnd;
		}
		size++;
		return true;
	}

	/**
	 * 순번을 찾아서 받아오는 값을 넣어준다.
	 * @param index
	 * 순번
	 * @param str
	 * 받아오는값
	 * @author NamSangYuop
	 */
	public void add(int index, String str) {
		checkBoundException(index);
		Node newnode = new Node(str);
		if (index == 0) {
			newnode.next = first;
			first = newnode;
		} else {
			Node node = first;
			for (int i = 0; i < index - 1; i++) {
				node = node.next;
			}
			newnode.next = node.next;
			node.next = newnode;
		}

		size++;
	}
	
	/**
	 * 마지막 순번에 넣어줄 값을 모두 넣는 메소드.
	 * @param c
	 * String형태의 값
	 * @author NamSangYuop
	 */
	public boolean addAll(List<String> c) {
		for (int i = 0; i < c.size(); i++) {
			add(c.get(i));
		}
		return false;
	}
	
	/**
	 * 넣어줄 순번에 넣어줄 값을 모두 넣는 메소드. 
	 * @param index
	 * @param c
	 * @author NamSangYuop
	 */
	public boolean addAll(int index, List<String> c) {
		checkBoundException(index);
		for (int i = 0; i < c.size(); i++) {
			add(index, c.get(i));
			index++;
		}
		return false;
	}
	/**
	 * 넘어온 인덱스번째 값을 반환.
	 * @param index
	 * @author NamSangYuop
	 */
	public String get(int index) {
		checkBoundException(index);
		Node fnode = first;
		for (int i = 0; i < index; i++) {
			fnode = fnode.next;
		}
		return fnode.data;
	}
	/**
	 * 값이 들어가있는지 없는지 확인하는 메소드.
	 * @author NamSnagYuop
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}
	/**
	 * 요소가 있는지 없는지 확인. true/false반환
	 * @param str
	 * @author NamSangyuop
	 */
	public boolean contains(String str) {
		Node node = first;
		for (int i = 0; i < size - 1; i++) {
			if (node.data.equals(str)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	/**
	 * 모든 요소가 들어있는지 확인/ 하나라도 없으면 false, 다 들어가있으면 true반환.
	 * @param c
	 * @return
	 */
	public boolean containsAll(List<String> c) {
		for (int i = 0; i < c.size(); i++) {
			if (contains(c.get(i)) == false) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 찾을 문자를 삭제
	 * @param str
	 * @author NamSangYuop 
	 */
	public boolean remove(String str) {
		Node node = first;
		for (int i = 0; i < size; i++) {
			if (node.data.equals(str)) {
				remove(i);
			}
			node = node.next;
		}
		return true;
	}
	/**
	 * 찾을 순번째에 문자를 삭제.
	 * @param index
	 * @author NamSangYuop 
	 */
	public String remove(int index) {
		checkBoundException(index);
		if (index == 0) {
			first = first.next;
		} else {
			Node node = first;
			for (int i = 0; i < index - 1; i++) {
				node = node.next;
			}
			node.next = node.next.next;
		}
		size--;

		return null;
	}
	
	/**
	 * c.size()안에 들어있는 값을 size만큼 돌리고 삭제.
	 * @param c
	 * @author NamSangYuop 
	 */
	public boolean removeAll(List<String> c) {
		for(int i = 0; i < c.size(); i++ ) {	
			for(int j = 0; j < size; j++) {				
				remove(c.get(i));
			}
		}
		return true;
	}
	
	/**
	 * 전부삭제후 받아오는 데이터를 추가.
	 * @param c
	 * 문자형으로 받아오는 값
	 */
	public boolean retainAll(List<String> c) {
		clear();
		addAll(c);
		return true;
	}
	
	//전부 삭제
	public void clear() {
		size = 0;
		first = null;
	}
	/**
	 * 첫번째부터 비교하여 i값을 반환.
	 * @param str
	 * @author NamSangYuop
	 */
	public int indexOf(String str) {
		Node node = first;
		for (int i = 0; i < size; i++) {
			if (node.data.equals(str)) {
				return i;
			}
			node = node.next;
		}

		return -1;
	}

	/**
	 * 맨끝에서부터 비교하여 temp를 반환.
	 * @param str 
	 * 받아오는 문자값을 node.문자값이랑 같은지 확인하고 같으면 인트형인 temp랑 같게해준다.
	 * @return temp
	 * temp가 0이면 -1을 아니면 temp를 리턴해준다.
	 */
	public int lastIndexOf(String str) {
		Node node = first;
		int temp = 0;
		for (int i = 0; i < size; i++) {
			if (node.data.equals(str)) {

				temp = i;
			}
			node = node.next;
		}
		if (temp == 0) {
			return -1;
		} else {
			return temp;
		}
	}
	/**
	 * index번째에 있는 str값을 바꿔줌.
	 * @param index
	 * @param str
	 * @author NamSangYuop
	 */
	public String set(int index, String str) {
		checkBoundException(index);
		Node node = first;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
			node.data = str;

		return null;
	}
	//사이즈
	public int size() {

		return this.size;
	}

	// public Iterator<String> iterator() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	// public String[] toArray() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	//
	// public <String> String[] toArray(String[] a) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	// public ListIterator<String> listIterator() {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	//
	// public ListIterator<String> listIterator(int index) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	//
	// public List<String> subList(int fromIndex, int toIndex) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
