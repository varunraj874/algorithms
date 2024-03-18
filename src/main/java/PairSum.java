import java.util.*;

/**
 * Find the pairs whose sum equals to target. Avoid duplicate pairs.
 * <br/>
 * Time complexity should be O(n)
 */
public class PairSum {
	public static void main(String[] args) {
		int target = 11;
		int[]  arr  = { 3, 2, 7, 1, 8, 9, 4, 5, 6};
		pairs(arr, target);
	}

	static void pairs(int[] arr, int target) {
		Set<Integer> processed = new HashSet<>();
		HashMap<Integer, Integer> pairs = new HashMap<>();

		for (int num: arr) {
			if(processed.contains(target - num)) {
				pairs.put(num, target-num);
			} else {
				processed.add(num);
			}
		}

		if(!pairs.isEmpty()) {

			System.out.println("Pairs which sum are " + target);
			for (Map.Entry<Integer, Integer> pair: pairs.entrySet()) {
				System.out.println(pair.getKey() + ", " + pair.getValue());
			}
		} else {
			System.out.println("No pair found which sum is "+ target);
		}
	}
}
