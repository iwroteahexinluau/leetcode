/* https://leetcode.com/problems/find-and-replace-pattern/description/
 * 890. Find and Replace Pattern
 *
 * Initial Approach:
 * We loop through the array words checking if each word can match the string pattern.
 * A word is valid if each letter in pattern maps to a letter in word with no two letters
 * mapping to different letters. We use a hash map to keep track of the map of the letter
 * in pattern to the letter in word. If a map already exists to the pattern letter, the
 * word letter must match it, as well as not already be used for a different mapping of
 * a pattern letter. If it's valid and we reach the end of the word, we add it to the
 * array, otherwise if it's invalid we break and move to the next word.
 *
 * Time O(m * n), Space O(1)
 * n = words[i].length(), m = words.length
 * Under the problem's constraints, space is O(1) instead of O(n)
 *
 * Alternate Approach:
 * Instead of using a hash map and a set, we can use indexOf() on each character which
 * will return the first position of that character. So if there are any duplicate 
 * characters, it will return the first index. Then we check equivalence with the
 * indexOf() each character in pattern.
 *
 * Time O(m * n^2), Space O(1)
 * indexOf() is O(n) and we call it twice for each character, making it O(n^2)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    // initial approach
    public static List<String> findAndReplace(String[] words, String pattern) {
        HashMap<Character, Character> seen = new HashMap<>();
        HashSet<Character> alreadyUsed = new HashSet<>();
        List<String> results = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            seen.clear();
            alreadyUsed.clear();
            for (int j = 0; j < words[i].length(); j++) {
                char pLetter = pattern.charAt(j);
                char wLetter = words[i].charAt(j);
                if (seen.containsKey(pLetter) && seen.get(pLetter) != wLetter) {
                    break;
                } else if (!seen.containsKey(pLetter) && alreadyUsed.contains(wLetter)) {
                    break;
                // we can add word immediately if last character is valid
                } else if (j == words[i].length() - 1) {
                    results.add(words[i]);
                } else {
                    seen.put(pLetter, wLetter);
                    alreadyUsed.add(wLetter);
                }
            }
        }
        return results;
    }
    // alternative approach
    public static List<String> optimizedFindAndReplace(String[] words, String pattern) {
        List<String> results = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.indexOf(word.charAt(i)) != pattern.indexOf(pattern.charAt(i))) {
                    break;
                } else if (i == word.length() - 1) {
                    results.add(word);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String[] w1 = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String p1 = "abb";
        String[] w2 = {"a", "b", "c"};
        String p2 = "a";

        System.out.println(findAndReplace(w1, p1));
        System.out.println(findAndReplace(w2, p2));

        System.out.println(optimizedFindAndReplace(w1, p1));
        System.out.println(optimizedFindAndReplace(w2, p2));
    }
}
