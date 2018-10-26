package doje.sy.sort.day1008;

import java.util.ArrayList;

public class BubbleSort {
	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		arrList.add(10);
		arrList.add(1);
		arrList.add(3);
		arrList.add(2);
		arrList.add(4);
		arrList.add(12);
		arrList.add(11);
		arrList.add(5);
		arrList.add(6);
		arrList.add(7);
		arrList.add(9);
		arrList.add(8);
		
		for (int i = 0; i < arrList.size(); i++) {
			System.out.print("["+arrList.get(i)+"]");
		}
		
		System.out.println();
		
		int temp;
		for (int i = 0; i < arrList.size(); i++) {
			for (int j = 0; j < arrList.size()-1; j++) { //(i+1)
				if(arrList.get(j) > arrList.get(j+1)) {
					temp = arrList.get(j+1);
					arrList.set(j+1, arrList.get(j));
					arrList.set(j, temp);
				}
			}
		}
		System.out.println("\t"+"======버블정렬======");
		for(int i = 0; i < arrList.size(); i++) {
			System.out.print("["+arrList.get(i)+"]");
		}
	}
}
