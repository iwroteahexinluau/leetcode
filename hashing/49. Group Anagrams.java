/* https://leetcode.com/problems/group-anagrams/description/
 * 49. Group Anagrams
 *
 * We can loop through each word and build an anagram map that tracks the number of each
 * letter. Then, we can convert it into a string to use as a key in a hash map. This
 * allows us to quickly lookup if we've already seen the anagram. The value of the
 * hash map tells us the position of that group in the ArrayList output.
 *
 * Time O(n * m), Space O(n)
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        HashMap<String, Integer> seen = new HashMap<>();

        int pos = 0;
        for (int i = 0; i < strs.length; i++) {
            int[] map = new int[26];
            String word = strs[i];
            // building the anagram map for each word
            for (int j = 0; j < word.length(); j++) {
                map[word.charAt(j) - 97]++;
            }
            // turning the anagram map array into a string key to use in the hash map 
            StringBuilder keySB = new StringBuilder();
            for (int j = 0; j < map.length; j++) {
                keySB.append(map[j]).append(" ");
            }
            String key = keySB.toString();

            // if it is a matching anagram, add it the pre-existing group
            if (seen.containsKey(key)) {
                groups.get(seen.get(key)).add(word);
            // if it is a new anagram, make a new group
            } else {
                seen.put(key, pos);
                List<String> newGroup = new ArrayList<>();
                newGroup.add(word);
                groups.add(newGroup);
                pos++;
            }
        }
        return groups;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs1 = {""};
        String[] strs2 = {"a"};
        String[] strs3 = {"abbbbbbbbbbb", "aaaaaaaaaaab"};

        System.out.println(groupAnagrams(strs));
        System.out.println(groupAnagrams(strs1));
        System.out.println(groupAnagrams(strs2));
        System.out.println(groupAnagrams(strs3));
    }
}
