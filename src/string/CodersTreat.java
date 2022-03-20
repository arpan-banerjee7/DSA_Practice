package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Coder's Treat
// hackerrank.com/contests/versatile-array/challenges/coders-treat/problem

public class CodersTreat {
	private static int lowerBoundBS(List<Integer> arr, int low, int high, int target) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr.get(mid) == target) {
				// the position of last element
				while (mid + 1 < arr.size() && arr.get(mid + 1) == target)
					mid++;
				return mid;
			}
			if (arr.get(mid) < target)
				low = mid + 1;
			else
				high = mid - 1;

		}
		return high;
	}

	public static List<Integer> treat_time(List<Integer> price, List<Integer> query) {
		// Write your code here
		List<Integer> res = new ArrayList<>();

		int n = price.size();
		int m = query.size();
		Collections.sort(price);
		for (int q : query) {
			int pos = lowerBoundBS(price, 0, n - 1, q);
			res.add(pos + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		/*Sample Input 0

		5
		4
		3 10 8 6 11
		1 10 3 11
		Sample Output 0

		0 4 1 5
		Explanation 0

		On the first day, Jenny won't be able to buy a drink in any of the shops.

		On the second day, Jenny can buy a drink in the shops 1, 2, 3 and 4.

		On the third day, Jenny can buy a drink only in the shop number 1.

		Finally, on the last day Jenny can buy a drink in any shop.
		*/

	}

}
