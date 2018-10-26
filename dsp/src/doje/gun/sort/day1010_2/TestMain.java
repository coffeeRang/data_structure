package doje.gun.sort.day1010_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**@date 2018.10.10
 * @author kimgun
 *	테스트용 클래스
 */
public class TestMain {
	/**정렬 테스트용 메소드
	 * @param args
	 */
	public static void main(String[] args) {
		SortService sort = new MinMaxSort();

		List<Integer> list = new ArrayList<Integer>(); //정렬할 값들이 들어있는 리스트

		//값 추가
		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}

		Collections.shuffle(list); //List를 섞어줌.

		System.out.println(" =================== 정렬 전 ================");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		System.out.println();

		list = sort.ascSort(list);	//배열을 오름차순 정렬

		System.out.println(" =================== 정렬 후 ================");
		System.out.println(" 내림차순 : ");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		System.out.println();

		list = sort.descSort(list);	//배열을 내림차순 정렬

		System.out.println(" 오름차순 : ");

		for (int i = 0; i < list.size(); i++) {
			System.out.print(" [");
			System.out.print(list.get(i));
			System.out.print("] ");
		}
		System.out.println();
	}
}
