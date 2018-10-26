package doje.dh.sort.day1010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyBubbleSort {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		
		for (int i = 0; i < 6; i++) {
			list.add(i);
		}
		
		System.out.println("---------------------- 값 등록 ----------------------");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
			
		}
		
		Collections.shuffle(list);
		System.out.println("\n ---------------------- 무작위 배치 ----------------------");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		
		// 오름차순 처리
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - (i + 1); j++) {
				if (list.get(j) > list.get(j + 1)) {
					int tempValue = list.get(j + 1);
					list.set(j + 1, list.get(j));
					list.set(j, tempValue);
				}
			}
		}
		
		System.out.println("\n ---------------------- 오름차순 ----------------------");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		
		
		// 내림차순 처리
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - (i + 1); j++) {
				if (list.get(j) < list.get(j + 1)) {
					int tempValue = list.get(j + 1);
					list.set(j + 1, list.get(j));
					list.set(j, tempValue);
				}
			}
		}
		
		
		System.out.println("\n ---------------------- 내림차순 ----------------------");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
		
	}
	

}
