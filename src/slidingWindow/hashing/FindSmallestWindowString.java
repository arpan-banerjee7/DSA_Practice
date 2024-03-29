package slidingWindow.hashing;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/contests/test-your-skills-in-hashing/challenges/find-the-smallest-window-string/problem
/*
* Given two strings str and ptr. Find the smallest window in the str consisting of all the characters of ptr.

Expected Time Complexity: O(n + m)

Where n is the length of string str and m is the length of ptr

Input Format

Input 1 : Str = "zoomlazapzo"

Input 2: Ptr = "oza"
Constraints

1 <= str.length

ptr.length <= 10^5

Output Format

o/p: apzo

"apzo" is the smallest 
substring in which "oza" can be found
Sample Input 0

zoomlazapzo
oza
Sample Output 0

apzo
*/
public class FindSmallestWindowString {
	public static String findWindow(String s, String ptr) {
		// Write your code here
		int n = s.length();
		int mapSize = 0;
		int minLength = Integer.MAX_VALUE;
		String res = "";

		// to keep count of unique chars of ptr
		Map<Character, Integer> charCount = new HashMap<>();
		for (char p : ptr.toCharArray()) {
			charCount.put(p, charCount.getOrDefault(p, 0) + 1);
		}

		// to understand that we have got all our chars in the current window
		mapSize = charCount.size();

		int start = 0;
		for (int end = 0; end < n; end++) {
			char endChar = s.charAt(end);

			// found a cahr of ptr, so reduce the freq
			// if freq=0 that means we have exhausted all of it, so reduce mapSize by one
			// search for remaining chars
			if (charCount.containsKey(endChar)) {
				charCount.put(endChar, charCount.get(endChar) - 1);
				if (charCount.get(endChar) == 0) {
					mapSize--;
				}
			}

			// we have found all the chars in this window
			while (mapSize == 0) {

				if ((end - start + 1) < minLength) {
					minLength = end - start + 1;
					res = s.substring(start, end + 1);
				}

				// start reducing the size of the window, and check if we still have all the
				// chars of the
				char startChar = s.charAt(start);
				if (charCount.containsKey(startChar)) {
					charCount.put(startChar, charCount.get(startChar) + 1);
					if (charCount.get(startChar) == 1) {
						mapSize++;
					}
				}
				start++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "zoomlazapzo";
		String ptr = "oza";
		System.out.println(findWindow(s, ptr)); // Output:"apzo"

	}

}
