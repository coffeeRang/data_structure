package doje.dh.sort.day1010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySelectionSort {
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 6; i++) {
			list.add(i);
		}
		
		System.out.println("---------------------- 값 등록 결과 ----------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		
		Collections.shuffle(list);
		System.out.println("\n ---------------------- 무작위 배치 결과 ----------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}

		// list size : 6
		// 오름차순 : 
		System.out.println("\n ---------------------- 오름차순 결과 ----------------------");
		for (int i = 0; i < list.size() - 1; i ++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) > list.get(j)) {
					int tempValue = list.get(j);
					list.set(j, list.get(i));
					list.set(i, tempValue);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		
		// 내림차순 : 
		System.out.println("\n ---------------------- 내림차순 결과 ----------------------");
		for (int i = 0; i < list.size() - 1; i ++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) < list.get(j)) {
					int tempValue = list.get(j);
					list.set(j, list.get(i));
					list.set(i, tempValue);
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		
		
		
		
	}

}
