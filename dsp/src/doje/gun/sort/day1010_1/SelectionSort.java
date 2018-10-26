package doje.gun.sort.day1010_1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author kimgun
 * @date 2018.10.08
 */
public class SelectionSort {
	/**선택정렬
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
		System.out.println();
		System.out.println("******************** 선택 정렬 *********************");
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) > list.get(j)) {
					int temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		System.out.println(" ====================오른차순=======================");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) < list.get(j)) {
					int temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		System.out.println();
		System.out.println(" ====================내림차순=======================");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
	}
}
