package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldCloudData {

private static List<String> split(String s) {
		int n = s.length();
		List<String> words = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (Character.isLetter(s.charAt(i))) {
				sb.append(s.charAt(i));
			} else if (s.charAt(i) == '\'') {
				sb.append(s.charAt(i));
			} else if (i > 0 && i < n && s.charAt(i) == '-' && Character.isLetter(s.charAt(i - 1))
					&& Character.isLetter(s.charAt(i + 1))) {
				sb.append(s.charAt(i));
			} else if (i != 0 && !(sb.length() == 0)) {
				words.add(sb.toString());
				sb = new StringBuilder();
			}
		}
		return words;
	}

	private static void buildWordCloud(String s) {
		List<String> words = split(s);
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			String sentenceCaseWord = Character.toUpperCase(word.charAt(0)) + word.substring(1);
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else if (map.containsKey(word.toLowerCase())) {
				map.put(word.toLowerCase(), map.get(word.toLowerCase()) + 1);
			} else if (map.containsKey(word.toUpperCase())) {
				int value = map.remove(word.toUpperCase());
				map.put(word, value + 1);
			} else if (map.containsKey(sentenceCaseWord)) {
				int value = map.remove(sentenceCaseWord);
				map.put(word, value + 1);
			} else {
				map.put(word, 1);
			}

		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "--> " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		// String s = "After beating the eggs, Dana read-on the next step:Add milk and
		// eggs, then add flour and sugar.";
		String s = "The Great Bill's finished his cake at the edge-on but- but His but the Great bill's of the cliff.";
		buildWordCloud(s);
	}

}