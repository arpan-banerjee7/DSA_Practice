package arrays;

import java.util.Iterator;
import java.util.Stack;
// 1673. Find the Most Competitive Subsequence

/*
 * Difference between Subarray, Subsequence, and Subset
 * https://www.techiedelight.com/difference-between-subarray-subsequence-subset/
 * https://www.youtube.com/watch?v=Ol7yz0XKKLw
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/submissions/
 */

// TC-o(n)- Monotonously increasing stack
public class FindMostCompetitiveSubsequence {

	public static int[] mostCompetitive(int[] nums, int k) {
		int n = nums.length;
		Stack<Integer> st = new Stack<>();
		int[] res = new int[k];
		int rem = n - k;
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && st.peek() > nums[i] && rem > 0) {
				st.pop();
				rem--;
			}
			st.push(nums[i]);

		}
		while (rem > 0) {
			st.pop();
			rem--;
		}
		for (int i = k - 1; i >= 0; i--) {
			res[i] = st.pop();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 5, 2, 6 };
		int k = 2;
		int[] res = mostCompetitive(nums, k); // Output: [2,6]
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

}
