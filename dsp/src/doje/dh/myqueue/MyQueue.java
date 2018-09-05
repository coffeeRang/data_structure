package doje.dh.myqueue;

import java.util.NoSuchElementException;

public class MyQueue {
	public String[] arr;
	public int size;
	
	public MyQueue() {
		this.size = 0;
		arr = new String[10];
	}
	

	/**
	 * queue 에 데이터 더하는 add method
	 * @author dhkim3523@awasoft.co.kr
	 * @param str
	 * @return true
	 */
//	public boolean add(String str) throws IllegalStateException, ClassCastException, NullPointerException, IllegalArgumentException {
	public boolean add(String str) {
		boolean returnFlag = true;
//		System.out.println(">> add str : " + str);
		
		if (str == null) {
//			System.out.println(true);
			throw new NullPointerException("null 값은 들어갈 수 없습니다.");
		}
		
		if (!(str instanceof String)) {
			System.out.println(">> add : " + true);
			throw new ClassCastException("String 타입만 입력이 가능합니다.");
			
		} else {
			System.out.println(false);
		}
		
		arr[size] = str;
		size++;
		
		return returnFlag;
		
	}
	
	/**
	 * Queue에 데이터 더하는 offer method
	 * @param str
	 * @return
	 */
	public boolean offer(String str) {
		
		boolean returnFlag = true;
		try {
			if (size >= arr.length) {
				returnFlag = false;	
			}
			arr[size] = str;
			size++;

		} catch (Exception e) {
			returnFlag = false;
			e.printStackTrace();
			
		} finally {
			return returnFlag;

		}
	}

	
	/**
	 * Queue head 에 있는 값 조회하는 메서드
	 * @author dhkim@awasoft.co.kr
	 * @return
	 */
	public String element() {
		if (arr[0] == null) {
			throw new NoSuchElementException();			
		}

		return arr[0];
	}

	/**
	 * Queue head 에 있는 값 조회하는 메서드
	 * @author dhkim@awasoft.co.kr
	 * @return
	 */
	public String peek() {
		String returnValue = null;
		if (arr[0] != null) {
			returnValue = arr[0];
		}

		return returnValue;
	}


	/**
	 * Queue head 에 있는 값 삭제하는 poll method
	 * @return
	 */
	public String poll() {
		String returnValue = arr[0];
		
		if (size == 0) {
			arr[0] = null;
		} else {
			for (int i = 1; i < size; i++) {
				arr[i -1] = arr[i];
			}
			arr[size-1] = null;
			size--;
		}
		
		return returnValue;
	}

	
	/**
	 * Queue head 에 있는 값 삭제
	 * @return
	 */
	public String remove() {
		String returnValue = arr[0];
		if (size == 0) {
			throw new NoSuchElementException("head 에 값이 없습니다.");
		}
		return returnValue;
	}
	
	
	/**
	 * Queue 에 값 확인하기 위한 메서드(테스트용)
	 * @param idx
	 * @return
	 */
	public String get(int idx) {
		return arr[idx];
		
	}


	/**
	 * 현재 data 들어갈 index 위치 값(테스트용) 
	 * @author dhkim
	 * @return
	 */
	public int lastIndex() {
		return this.size;
	}
}
