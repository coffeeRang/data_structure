package doje.gun.sort.day1010_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kimgun
 * @date 2018.10.10
 */
public class MinMaxSort implements SortService {
	int min; //배열의 최소값
	int max; //배열의 최대값

	public MinMaxSort() {
		this.min = Integer.MAX_VALUE;
		this.max = Integer.MIN_VALUE;
	}

	/* (non-Javadoc)
	 * @see sort.Sort#ascSort(java.util.List)
	 * 넘어온 List를 오름차순하여 반환함.
	 */
	public List<Integer> ascSort(List<Integer> list) {
		int maxIdx = -1; //최대값이 저장되어 있는 인덱스. **배열의 인덱스는 0부터이기 때문에 초기 값을 -1로 잡음
		ArrayList<Integer> returnList = new ArrayList<Integer>(); //정렬된 값들이 들어있는 반환할 리스트

		while (list.size() != 0) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) > this.max) {
					this.max = list.get(j);
					maxIdx = j;
				}
			}
			list.remove(maxIdx);

			returnList.add(this.max);

			this.max = Integer.MIN_VALUE;

		}
		return returnList;
	}

	/* (non-Javadoc)
	 * @see sort.Sort#descSort(java.util.List)
	 * 넘어온 List를 내림차순하여 반환함.
	 */
	public List<Integer> descSort(List<Integer> list) {
		int minIdx = -1;	//최소값이 저장되어 있는 인덱스. **배열의 인덱스는 0부터이기 때문에 초기 값을 -1로 잡음

		ArrayList<Integer> returnList = new ArrayList<Integer>();	//정렬된 값들이 들어있는 반환할 리스트

		while (list.size() != 0) {
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) < this.min) {
					this.min = list.get(j);
					minIdx = j;
				}
			}
			list.remove(minIdx);

			returnList.add(this.min);

			this.min = Integer.MAX_VALUE;

		}
		return returnList;
	}
}