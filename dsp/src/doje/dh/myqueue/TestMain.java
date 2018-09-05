package doje.dh.myqueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TestMain {
	
	public static void main(String[] args) {
		MyQueue que = new MyQueue();
		
		System.out.println("현재 que index 위치 값 : " + que.lastIndex());
		
		for (int i = 0; i < 13; i ++) {
//			System.out.println(i + " 번째 횟수 : " + que.add(", add테스트" + 1));
//			System.out.println(i + " 번째 횟수 : " +  que.offer("offer테스트" + i) + ", offer테스트" + i);
		}
		que.add(null);
		
		System.out.println(">> 변환 전 arr size : " + que.size);
		
//		System.out.println(que.offer("테스트1"));

		System.out.println(">> que : " + que.poll());

		System.out.println(">> 변환 후 arr size : " + que.size);
		
//		System.out.println(que.remove());
//		System.out.println(que.element());
//		System.out.println(que.peek());
		
		
		
		
		

		
		
	}
	
	
	
	
	
	
	

}
