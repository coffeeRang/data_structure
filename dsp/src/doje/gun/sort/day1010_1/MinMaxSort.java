package doje.gun.sort.day1010_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author kimgun
 * @date 2018.10.10
 */
public class MinMaxSort {
	/**최소값, 최대값을 이용해서 정렬
	 * @param args
	 */
	public static void main(String[] args) {
		int min = Integer.MAX_VALUE; //배열의 최소값
		int max = Integer.MIN_VALUE; //배열의 최대값

		ArrayList<Integer> list = new ArrayList<Integer>(); //정렬할 값들이 들어있는 리스트

		//값 추가
		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}

		Collections.shuffle(list);

		System.out.println(" =================== 정렬되지 않은 값 ================");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		System.out.println();
		System.out.println(" =================== 내림차순 정렬 ==================");

		int maxI = -1; //최대값이 저장되어 있는 인덱스. **배열의 인덱스는 0부터이기 때문에 초기 값을 -1로 잡음
		ArrayList<Integer> tempList = new ArrayList<Integer>(); //정렬된 값들이 들어있는 임시 리스트

		while (list.size() != 0) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) > max) {
					max = list.get(j);
					maxI = j;
				}
			}
			list.remove(maxI);

			tempList.add(max);

			max = Integer.MIN_VALUE;

		}
		list = tempList;

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}

		System.out.println();
		System.out.println(" =================== 오름차순 정렬 ==================");

		int minI = -1;
		tempList = new ArrayList<Integer>();

		while (list.size() != 0) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) < min) {
					min = list.get(j);
					minI = j;
				}
			}
			list.remove(minI);

			tempList.add(min);

			min = Integer.MAX_VALUE;

		}
		list = tempList;

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
	}
}