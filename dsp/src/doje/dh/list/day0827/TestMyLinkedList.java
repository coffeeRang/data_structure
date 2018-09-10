package doje.dh.list.day0827;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestMyLinkedList {
	
	public Node frontNode;
	public int size = 0;
	
	public class Node {
		public Node(String input) {
			this.data = input;
			this.next = null;
		}
		public String data;
		public Node next;
	}

	
	public boolean add(String arg0) {
		// TODO Auto-generated method stub
		if (frontNode == null) {
//			Node newNode = new Node();
//			newNode.data = arg0;
//			frontNode = newNode;
			
		}
		size ++;
		
		return false;
	}

	
	public void add(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public boolean addAll(Collection<? extends String> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean addAll(int arg0, Collection<? extends String> arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public String get(int arg0) {
		
		
		return null;
	}

	
	public int indexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public ListIterator<String> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ListIterator<String> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public String remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public String set(int arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int size() {
		return this.size;
	}

	
	public List<String> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
