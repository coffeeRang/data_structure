package doje.gun.list.arraylist.day0823;

import java.util.List;
import java.util.function.UnaryOperator;

public class MyArrayList {
	private String[] arr;
	private int size;

	public MyArrayList() {
		this.arr = new String[0];
		this.size = 0;
	}

	public boolean add(String e) {
		if (size >= arr.length) {
			String tempArr[] = new String[arr.length + 1];
			System.arraycopy(arr, 0, tempArr, 0, arr.length);

			arr = tempArr;
		}
		arr[size] = e;
		size++;
		return false;
	}

	public void add(int index, String element) {
		// TODO Auto-generated method stub
		if (size < index) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}
		arr[index] = element;
	}

	public boolean addAll(List<String> c) {
		// TODO Auto-generated method stub
		for (int i = 0; i < c.size(); i++) {
			if (size >= arr.length) {
				String tempArr[] = new String[arr.length + 1];
				System.arraycopy(arr, 0, tempArr, 0, arr.length);

				arr = tempArr;
			}
			arr[size] = c.get(i);
			size++;
		}
		return false;
	}

	public boolean addAll(int index, List<String> c) {
		for (int i = 0; i < c.size(); i++) {
			if (size >= arr.length) {
				String tempArr[] = new String[arr.length + 1];
				System.arraycopy(arr, 0, tempArr, 0, arr.length);

				arr = tempArr;
			}
			arr[index] = c.get(i);
			index++;
			size++;
		}
		return false;
	}

	public void clear() {
		arr = new String[0];
		size = 0;
	}

	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		for (int i = 0; i < size; i++) {
			if (arr[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsAll(List<String> c) {
		// TODO Auto-generated method stub
		int num = 0;
		for (int i = 0; i < c.size(); i++) {
			for (int j = 0; j < size; j++) {
				if (arr[j].equals(c.get(i))) {
					num++;
				}
			}
		}
		if (c.size() == num) {
			return true;
		}
		return false;
	}

	public boolean equals(Object o) {
		return false;
	}

	public String get(int index) {
		if (size < index) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}

		return arr[index];
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (arr[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(Object o) {
		int num = 0;
		for (int i = 0; i < size; i++) {
			if (arr[i].equals(o)) {
				num = i;
			}
		}
		if (num == 0) {
			return -1;
		} else {
			return num;
		}
	}

	public String remove(int index) {
		if (size <= index) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}

		String[] tempArr = new String[size - 1];
		int num = 0;
		for (int i = 0; i < size; i++) {
			if (i != index) {
				tempArr[num] = arr[i];
				num++;
			}
		}
		arr = tempArr;
		size = size - 1;
		return null;
	}

	public boolean remove(Object o) {
		String[] tempArr = new String[size - 1];
		int num = 0;
		for (int i = 0; i < size; i++) {
			if (!arr[i].equals(o)) {
				tempArr[num] = arr[i];
				num++;
			}
		}
		arr = tempArr;
		size = size - 1;

		return false;
	}

	public boolean removeAll(List<String> c) {
		int idx = 0;
		for (int i = 0; i < c.size(); i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].equals(c.get(i))) {
					arr[j] = "";
					idx++;
				}
			}
		}
		String[] tempArr = new String[size - idx];
		
		idx = 0;
		for (int i = 0; i < size; i++) {
			if(!arr[i].equals("")) {
				tempArr[idx] = arr[i];
				idx++;
			}
		}

		arr = tempArr;
		size = tempArr.length;
		return false;
	}

	public boolean retainAll(List<String> c) {
		int idx = 0;
		for (int i = 0; i < c.size(); i++) {
			for (int j = 0; j < arr.length; j++) {
				if (!arr[j].equals(c.get(i))) {
					arr[j] = "";
					idx++;
				}
			}
		}
		System.out.println("======");
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		System.out.println("======");
//		String[] tempArr = new String[size - idx];
//		
//		idx = 0;
//		for (int i = 0; i < size; i++) {
//			if(!arr[i].equals("")) {
//				tempArr[idx] = arr[i];
//				idx++;
//			}
//		}
//
//		arr = tempArr;
//		size = tempArr.length;
		return false;
	}

	public String set(int index, String element) {
		if (size <= index) {
			throw new ArrayIndexOutOfBoundsException("인덱스를 확인하세요.");
		}

		arr[index] = element;
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
}