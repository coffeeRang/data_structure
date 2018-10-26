package doje.gun.sort.day1010_1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kimgun
 * @date 2018.10.08
 */
public class BubbleSort {
	/**버블정렬
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}

		Collections.shuffle(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		System.out.println("");

		System.out.println("******************** 버블 정렬 *********************");
		System.out.println("======================오름차순======================");
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - (i + 1); j++) {
				if (list.get(j) > list.get(j + 1)) {
					int temp = list.get(j + 1);
					list.set(j + 1, list.get(j));
					list.set(j, temp);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		System.out.println();

		System.out.println("======================내림차순======================");
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - (i + 1); j++) {
				if (list.get(j) < list.get(j + 1)) {
					int temp = list.get(j + 1);
					list.set(j + 1, list.get(j));
					list.set(j, temp);
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
	}
}
