package doje.gun.sort.day1010_3;

import java.util.ArrayList;
import java.util.List;

import doje.gun.sort.day1010_2.SortService;

/**
 * @author kimgun
 * @date 2018.10.11
 * SortService를 implements 받아 최대값, 최소값을 사용하는 정렬 알고리즘을 구현한 클래스
 */
public class MinMaxSortImpl implements SortService {
	int max; //배열의 최소값
	int min; //배열의 최대값

	public MinMaxSortImpl() {
		this.min = Integer.MAX_VALUE;
		this.max = Integer.MIN_VALUE;
	}

	/* (non-Javadoc)
	 * @see sort.Sort#descSort(java.util.List)
	 * 넘어온 List를 오름차순하여 반환함.
	 * @author kimgun
	 */
	@Override
	public List<Integer> ascSort(List<Integer> list) {
		List<Integer> returnList = new ArrayList<Integer>(); //내림차순으로 정렬되어 리턴될 리스트

		int maxIdx = -1; //최대값이 저장되어 있는 index

		boolean[] isMaxOut = new boolean[list.size()]; //이미 한번 조건에서 걸린 적 있는 최대값인지를 판단

		//초기화
		for (int i = 0; i < isMaxOut.length; i++) {
			isMaxOut[i] = false;
		}

		for (int i = 0; i < list.size(); i++) {
			//초기화
			this.max = Integer.MIN_VALUE;

			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) > this.max && isMaxOut[j] == false) {
					this.max = list.get(j);
					maxIdx = j;
				}
			}
			isMaxOut[maxIdx] = true;
			returnList.add(this.max);
		}
		return returnList;
	}

	/* (non-Javadoc)
	 * @see sort.Sort#descSort(java.util.List)
	 * 넘어온 List를 내림차순하여 반환함.
	 * @author kimgun
	 */
	@Override
	public List<Integer> descSort(List<Integer> list) {
		List<Integer> returnList = new ArrayList<Integer>(); //내림차순으로 정렬되어 리턴될 리스트

		int minIdx = -1; //최소값이 저장되어 있는 index

		boolean[] isMinOut = new boolean[list.size()]; //이미 한번 조건에서 걸린 적 있는 최소값인지를 판단

		//초기화
		for (int i = 0; i < isMinOut.length; i++) {
			isMinOut[i] = false;
		}

		for (int i = 0; i < list.size(); i++) {
			//초기화
			this.min = Integer.MAX_VALUE;

			for (int j = 0; j < list.size(); j++) {

				if (list.get(j) < this.min && isMinOut[j] == false) {
					this.min = list.get(j);
					minIdx = j;
				}
			}
			isMinOut[minIdx] = true;
			returnList.add(this.min);
		}
		return returnList;
	}

	//	/* (non-Javadoc)
	//	 * @see sort.Sort#ascSort(java.util.List)
	//	 * 넘어온 List를 오름차순하여 반환함.
	//	 * @author kimgun
	//	 */
	//	@Override
	//	public List<Integer> ascSort(List<Integer> list) {
	//		int maxIdx = -1; //최대값이 저장되어 있는 인덱스. **배열의 인덱스는 0부터이기 때문에 초기 값을 -1로 잡음
	//		ArrayList<Integer> returnList = new ArrayList<Integer>(); //정렬된 값들이 들어있는 반환할 리스트
	//
	//		while (list.size() != 0) {
	//			for (int j = 0; j < list.size(); j++) {
	//				if (list.get(j) > this.max) {
	//					this.max = list.get(j);
	//					maxIdx = j;
	//				}
	//			}
	//			list.remove(maxIdx);
	//
	//			returnList.add(this.max);
	//
	//			this.max = Integer.MIN_VALUE;
	//
	//		}
	//		return returnList;
	//	}
	//
	//	/* (non-Javadoc)
	//	 * @see sort.Sort#descSort(java.util.List)
	//	 * 넘어온 List를 내림차순하여 반환함.
	//	 * @author kimgun
	//	 */
	//	@Override
	//	public List<Integer> descSort(List<Integer> list) {
	//		int minIdx = -1; //최소값이 저장되어 있는 인덱스. **배열의 인덱스는 0부터이기 때문에 초기 값을 -1로 잡음
	//
	//		ArrayList<Integer> returnList = new ArrayList<Integer>(); //정렬된 값들이 들어있는 반환할 리스트
	//
	//		while (list.size() != 0) {
	//			for (int j = 0; j < list.size(); j++) {
	//				if (list.get(j) < this.min) {
	//					this.min = list.get(j);
	//					minIdx = j;
	//				}
	//			}
	//			list.remove(minIdx);
	//
	//			returnList.add(this.min);
	//
	//			this.min = Integer.MAX_VALUE;
	//
	//		}
	//		return returnList;
	//	}
}