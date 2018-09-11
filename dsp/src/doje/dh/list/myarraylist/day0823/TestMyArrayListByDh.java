package doje.dh.list.arraylist.day0823;

import java.util.List;
import java.util.function.UnaryOperator;

public class TestMyArrayListByDh {
	// 배열
	private String[] arr;
	// 실질적 크기를 담당할 변수
	private int size;

	public TestMyArrayListByDh() {
		this.arr = new String[10];
		this.size = 0;
	}

	// 넘어온 파라미터 문자열을 배열의 마지막에 넣어주는 메소드
	public boolean add(String e) {
		// size가 배열의 크기보다 크거나 같은 경우 배열의 길이를 늘려줌
		if (size >= arr.length) {
			// 더 큰 크기의 배열을 생성
			String tempArr[] = new String[arr.length * 2];
			// 기존의 arr배열의 0번째 인덱스부터 tempArr배열의 0번째 인덱스부터 복사함
			System.arraycopy(arr, 0, tempArr, 0, arr.length);

			// arr배열을 tempArr배열의 주소로 할당
			arr = tempArr;
		}
		// 배열의 실질적 크기를 나타내는 size변수 번째의 인덱스에 들어온 파라미터의 값을 넣어줌(마지막 자리를 의미)
		arr[size] = e;
		// 배열의 실질적 크기를 늘려줌
		size++;

		return false;
	}

	// 넘어온 파라미터 문자열을 넘어온 파라미터 index번째부터 배열에 넣어주는 메소드
	public void add(int index, String element) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}

		add(element);
			
		// 배열의 마지막 자리부터 전 인덱스의 값을 오른쪽으로 이동
		System.out.println(">> size : " + size + ", index : " + index);
		for (int i = size; i >= index; i--) {
//			arr[i] = arr[i - 1];
			if (index == 0) {
				arr[i+1] = arr[i];
			} else {
				arr[i] = arr[i - 1];
			}
		}
		System.out.println("---------------------------------");
		// 실질적으로 index의 자리는 쓸모없는 값이 들어있으므로 값을 넣어줌
		arr[index] = element;
	}

	// 넘어온 파라미터 문자열 List를 배열의 마지막에 넣어주는 메소드
	public boolean addAll(List<String> c) {
		// 0부터 넘어온 리스트의 길이만큼 반복
		for (int i = 0; i < c.size(); i++) {
			// add메소드 호출
			add(c.get(i));
		}
		return false;
	}

	// 넘어온 파라미터 문자열 List를 넘어온 파라미터 index번째부터 배열에 넣어주는 메소드
	public boolean addAll(int index, List<String> c) {
		// 0부터 넘어온 리스트의 길이만큼 반복
		for (int i = 0; i < c.size(); i++) {
			// add메소드 호출
			add(index, c.get(i));
			index ++;
		}
		return false;
	}

	// 배열 초기화
	public void clear() {
		// arr = new String[10];
		size = 0;
	}

	// 넘어온 str 요소가 배열에 있는지 판단하는 메소드
	// 있으면 true
	// 없으면 false
	public boolean contains(String str) {
		// indexOf(str)이 -1보다 큰가?
		if (indexOf(str) > -1) {
			// 맞으면 true
			return true;
		}
		// if문에서 걸리지 않았으면 false
		return false;
	}

	// 넘어온 List안의 요소가 배열에 있는지 판단하는 메소드
	public boolean containsAll(List<String> c) {
		// 0부터 c의 size까지 i의 값을 증가
		for (int i = 0; i < c.size(); i++) {
			// contains 메소드에 c.get(i)를 파라미터로 넘김
			// 한번이라도 false가 나올 경우 false를 리턴
			if (contains(c.get(i)) == false) {
				return false;
			}
		}
		return true;
	}

	public String get(int index) {
		// 넘어온 index변수의 값이 실질적 배열의 크기인 size보다 크거나
		// 0보다 작나?
		if (size < index || index < 0) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}
		return arr[index];
	}

	// 넘어온 요소가 등장하는 첫번째 인덱스를 반환
	// 없을 경우 -1 리턴
	public int indexOf(String str) {
		for (int i = 0; i < size; i++) {
			// i번째 arr배열의 문자열이 str과 같나?
			if (arr[i].equals(str)) {
				// 맞으면 인덱스를 리턴
				return i;
			}
		}
		// 아닐 경우
		return -1;
	}

	// size가 0인지 판단하는 메소드
	public boolean isEmpty() {
		// size가 0인가?
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	// 넘어온 요소가 등장하는 마지막 인덱스를 반환
	// 없을 경우 -1 리턴
	public int lastIndexOf(String str) {
		// i가 배열의 실질적 크기인 size-1부터 i가 0보다 작거나 같을 때 까지 감소
		for (int i = size - 1; i >= 0; i--) {
			// i번째 arr배열의 문자열이 str과 같나?
			if (arr[i].equals(str)) {
				// 맞으면 인덱스를 리턴
				return i;
			}
		}
		// 틀리면
		return -1;
	}

//	public String remove(int index) {
	public boolean remove(int index) {
		// 넘어온 index파라미터 값이 실질적 크기인 size보다 큰가?
		// *있지도 않은 값을 삭제할 순 없음
		if (size < index || index < 0) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}
		boolean flag = false;
		// i가 index부터 size 작을 때까지 증가
		for (int i = index; i < size - 1; i++) {
			// i번째 arr배열의 값은 arr i + 1번째 값
			// 값을 왼쪽으로 밀어줌으로써 삭제와 같은 효과를 냄
			arr[i] = arr[i + 1];
			flag = true;
		}
		size--;
		return flag;
//		return null;
		
	}

	public boolean remove(String str) {
		// i가 0부터 size보다 작을 때까지 증가
		for (int i = 0; i < size; i++) {
			// i번째 arr배열의 문자열이 str과 같나?
			if (arr[i].equals(str)) {
				// remove 메소드 호출
				remove(i);
			}
		}
		return false;
	}

	// 넘어온 List안에 값들과 같은 값들은 모두 삭제하는 메소드
	public boolean removeAll(List<String> c) {
		// i가 0부터 넘어온 c의 size보다 작을 때까지 증가
		for (int i = 0; i < c.size(); i++) {
			// remove 메소드 호출
			remove(c.get(i));
		}
		return false;
	}

	// 넘어온 List안에 값들과 같은 값들만 남기고 모두 삭제하는 메소드
	public boolean retainAll(List<String> c) {
		clear();
		addAll(c);
		return false;
	}

	// index번째 배열의 값을 element 값으로 치환해주는 메소드
	public String set(int index, String element) {
		if (index > size || index < 0) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}
		// index번째 arr배열 값을 oldStr변수로 치환
		String oldStr = arr[index];
		// 값을 변경
		arr[index] = element;
		return oldStr;
	}

	// 전역변수 size를 리턴해주는 메소드
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
}