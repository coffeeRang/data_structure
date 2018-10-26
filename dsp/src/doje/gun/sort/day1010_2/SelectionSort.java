package doje.gun.sort.day1010_2;

import java.util.List;

/**
 * @author kimgun
 * @date 2018.10.10
 */
public class SelectionSort implements SortService{
	/* (non-Javadoc)
	 * @see sort.Sort#descSort(java.util.List)
	 * 넘어온 List를 내림차순하여 반환함.
	 */
	public List<Integer> descSort(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) > list.get(j)) {
					int temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see sort.Sort#ascSort(java.util.List)
	 * 넘어온 List를 오름차순하여 반환함.
	 */
	public List<Integer> ascSort(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) < list.get(j)) {
					int temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
		return list;
	}
}