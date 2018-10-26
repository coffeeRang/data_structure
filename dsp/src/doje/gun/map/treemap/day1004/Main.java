package doje.gun.map.treemap.day1004;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		java.util.TreeMap<String, String> tree = new java.util.TreeMap<String, String>();
		tree.put("새로운 값1", "김건");
		tree.put("새로운 값2", "아아아");

		Random ran = new Random();
		MyTreeMap<Integer, String> map = new MyTreeMap<Integer, String>();
		map.put(1, "1값");
		map.put(3, "3값");
		map.put(5, "5값");
		map.put(0, "0값");

//		map.remove(1);
		System.out.println(map.get(1));
		System.out.println(map.get(3));
		System.out.println(map.get(5));
		System.out.println(map.get(0));
		
//		map.view();
	}
}
