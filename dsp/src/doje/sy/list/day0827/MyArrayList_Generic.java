package doje.sy.list.day0827;

import java.util.List;

public class MyArrayList_Generic<E> {

	E[] arr;
	int size;

	public MyArrayList_Generic() {

		arr = (E[]) new Object[10]; // 배열을 10으로 잡아줌.
		size = 0; // 사이즈를 0으로 초기화
	}

	private void checkBoundException(int index) {

		if (index < 0 || index > size) {
			// 위치값이 0보다 작거나 사이즈값 보다 크거나 같으면 BoundsException을 띄운다.
			throw new IndexOutOfBoundsException("index값을 확인하세요.");
		}
	}

	public boolean add(E e) { // 맨뒤부터 값을넣음. ㅇ
		// 사이즈가 어레이크기보다 크거나 같고 사이즈가 0보다 작으면 구문 실행
		if (size >= arr.length || size < 0) {
			E[] data = (E[]) new Object[arr.length * 2];
			System.arraycopy(arr, 0, data, 0, arr.length);
			arr = data;
		}
		arr[size] = e; // arr배열 안에 들어있는 size 를 e로 변환
		size++; // 사이즈가 0이므로 늘려주어 값을 넣음

		return true;
	}

	// add(int index, String e) == 원하는 위치에 string 값을 넣음
	public void add(int index, E e) { // index = 위치 /size = arr.length에 들어있는 값 /arr.length = 크기
		checkBoundException(index);
		add(e); // add의 Exception부분을 호출.
		if (size >= 0) {

			for (int i = size - 1; i > index; i--) { // size로 잡고 index보다 크거나 같게 --를 해준다.

				arr[i] = arr[i - 1]; //
			}
		}

		arr[index] = e; // 원하는 index에 e값을 넣는다.

	}

	public boolean addAll(List<E> c) { // size값 맨뒤부터 붙임 ㅇ.
										// c.size()만큼 돌리고 i를 +해준다.
		for (int i = 0; i < c.size(); i++) {

			add(c.get(i));
		}

		return false;
	}

	public boolean addAll(int index, List<E> c) { // 위치값에 넣을값을 모두 넣고 쉬프트 한다.

		for (int i = 0; i < c.size(); i++) {

			add(index + i, c.get(i));
		}

		return false;
	}

	public void clear() { // 값을 0으로 만든다 ㅇ.

		// arr = new String[10];
		size = 0; // 사이즈를 0으로 초기화 한다.
		// arr = null; 못쓰게만든다.

	}

	public boolean contains(E str) { // 하나의 값이 들어가있는지 확인.
		return indexOf(str) >= 0;
		// for (int i = 0; i < size; i++) {
		// if (arr[i] == str ) {
		// return true;
		// }
		// }
		// return false;
	}

	public boolean containsAll(List<E> c) {  //contains 에서 이미 indexOf를 사용하기때문에 contains를
		for (int i = 0; i < c.size(); i++) { //false랑 비교해서 false면 false를 리턴해주고 아니면 true를
			if (contains(c.get(i)) == false) { //반환	
				return false;
			}
		}
		return true;
	}

	public E get(int index) {
		E str = arr[index];

		return str;
	}

	public int indexOf(E str) { // 오른쪽부터 검사하여 찾고자 하는 값의 첫번째 값을 반환

		for (int i = 0; i < size; i++) {

			if (arr[i] == str) { // 배열값과 파라미터 값이 같은지 체크

				return i; // 같으면 i값 반환 아니면 -1반환
			}
		}
		return -1;
	}

	public boolean isEmpty() {
		// 사이즈가 0이면 트루 반환 아니면 false
		// if (size == 0) {
		// return true;
		// }
		//
		// return false;
		return this.size == 0;
	}

	public int lastIndexOf(E str) { // indexOf와 반대로 오른쪽에서 부터 값을 반환한다.

		for (int i = size - 1; i >= 0; i--) { // 사이즈값을 0이될때까지 돌린다.

			if (arr[i] == str) {
				return i; // if문을 통과해서 맞으면 i값을 반환 여기서 i값은 위치값을 반환
			}
		}

		return -1; // if문을 통과해서 arr[i]과 str이 같지않으면 -1반환
	}

	public int remove(int index) {
		checkBoundException(index);
		for (int i = index; i < size - 1; i++) {
			arr[i] = arr[i + 1]; // 앞으로 땡겨주는 구문.
		}
		size--; // 삭제하고나서 size를 줄여주지 않으면 마지막에 남아있던 값이 그대로 남는다.
		return 1;
	}

	public boolean remove(Object o) {

		for (int i = 0; i < size; i++) { // 0부터 size값 만큼 확인.
			if (arr[i].equals(o)) { // 배열[i]와 str이 같은지 확인. 같으면 str값을 지우고 한칸씩 밀어서 채워준다.
				remove(i); // 지우고 한칸씩 채워주는 구문을 호출.
			}
		}

		return false;
	}

	public boolean removeAll(List<E> c) {
		for (int i = 0; i < c.size(); i++) { // 값이 들어온 만큼 그값을 삭제.

			remove(c.get(i)); // remove메소드 호출, c.get(i)값을 가져온다.
		}

		return false;
	}

	public boolean retainAll(List<E> c) {

		clear(); // 클리어 메소드를 호출하여 0으로 초기화해준다.
		addAll(c); // addAll메소드를 호출하고 값을 채워준다.
		return false;
	}

	public E set(int index, E e) {
		if (size < index) { // 위치값이 사이즈값보다 크면 띄운다.
			throw new IndexOutOfBoundsException("index값을 확인하세요.");
		}
		E oldStr = arr[index]; // 원래 배열안에 있던 값을 새로 만든 str에 저장한다.

		arr[index] = e; // index값을 e로 바꾼다.

		return oldStr; // 저장한 원래값을 반환해준다.
	}

	public int size() {

		return this.size; // size를 반환
	}

}
