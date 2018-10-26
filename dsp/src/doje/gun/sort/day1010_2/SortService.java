package doje.gun.sort.day1010_2;

import java.util.List;

/**@date 2018.10.10
 * @author kimgun
 *
 */
public interface SortService {
	/**파라미터로 받아온 list를 오름차순하여 반환함.
	 * @param list
	 * @return
	 */
	public List<Integer> ascSort(List<Integer> list);
	/**파라미터로 받아온 list를 내림차순하여 반환함.
	 * @param list
	 * @return
	 */
	public List<Integer> descSort(List<Integer> list);
}
