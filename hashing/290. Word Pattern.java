/* https://leetcode.com/problems/word-pattern/description/
 * 290. Word Pattern
 *
 * We loop through string pattern matching each letter with a word that is built from
 * string s. Each word is seperated by a space, so when we reach a space or the end of s,
 * we have fully built the word. We then use a hash map to check if that letter is
 * already maps to a word, and if it does, make sure that the words are the same. We also
 * use a set to check if the word is already being used with a different pattern. If the
 * pattern mapping to the word is valid, we add it to both the hash map and the set. We
 * also have to add additional guards checking that there are enough words in s to map to
 * the entire pattern, and that there are not too many words in s.
 *
 * Time O(m + n) -> O(n), Space O(n)
 * m = pattern.length(), n = s.length() 
 */

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> seen = new HashMap<>();
        HashSet<String> alreadyUsed = new HashSet<>();
        StringBuilder word = new StringBuilder();
        int j = 0;
        for (int i = 0; i < pattern.length(); i++) {
            word.setLength(0);
            char letter = pattern.charAt(i);
            // not enough words in s for the pattern
            if (j >= s.length()) {
                return false;
            }
            
            // build the word from s
            while (j < s.length() && s.charAt(j) != ' ') {
                word.append(s.charAt(j));
                j++;
            }
            String w = word.toString();
            // word does not match the previous pattern
            if (seen.containsKey(letter) && !seen.get(letter).equals(w)) {
                return false;
            // word is already associated with a different pattern
            } else if (!seen.containsKey(letter) && alreadyUsed.contains(w)) {
                return false;
            } else {
                seen.put(letter, w);
                alreadyUsed.add(w);
            }
            j++;
        }
        // if there are too many words in s then needed for the pattern
        if (j < s.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String p = "abba", n = "dog cat cat dog", n1 = "dog cat cat fish";
        String p1 = "aaaa", s1 = "dog cat cat dog"; 
        String p2 = "ab", s2 = "dog dog";
        String p3 = "a", s3 = "dog cat";
        String p4 = "ab", s4 = "dog";

        System.out.println(wordPattern(p, n));
        System.out.println(wordPattern(p, n1));
        System.out.println(wordPattern(p1, s1));
        System.out.println(wordPattern(p2, s2));
        System.out.println(wordPattern(p3, s3));
        System.out.println(wordPattern(p4, s4));
    }
}
