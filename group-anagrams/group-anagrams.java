

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> results = new HashMap<>();

		for (String str : strs) {
            char[] temp = str.toCharArray();
		    Arrays.sort(temp);
			String sorted = new String(temp);

			results.computeIfAbsent(sorted, key -> new ArrayList<>());
			results.get(sorted).add(str);
		}

		return new ArrayList<>(results.values());
    }
}