package doje.gun.sort.day1010_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kimgun
 * @date 2018.10.10
 */
public class BubbleSort implements SortService {
	/* (non-Javadoc)
	 * @see sort.Sort#descSort(java.util.List)
	 * 넘어온 List를 내림차순하여 반환함.
	 */
	@Override
	public List<Integer> descSort(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - (i + 1); j++) {
				if (list.get(j) > list.get(j + 1)) {
					int temp = list.get(j + 1);
					list.set(j + 1, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see sort.Sort#ascSort(java.util.List)
	 * 넘어온 List를 오름차순하여 반환함.
	 */
	@Override
	public List<Integer> ascSort(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size() - (i + 1); j++) {
				if (list.get(j) < list.get(j + 1)) {
					int temp = list.get(j + 1);
					list.set(j + 1, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}
}
