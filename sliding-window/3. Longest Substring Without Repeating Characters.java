/* https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 3. Longest Substring Without Repeating Characters
 *
 * We can use a sliding window to contain all unique characters to find the longest
 * substring in one pass. We loop through the string keeping track of the position of the
 * first unique character. We add each unique character to a set, and if we encounter a
 * duplicate, we move the left pointer until the duplicate is no longer in the set.
 *
 * Time O(n), Space O(n)
 */

import java.util.HashSet;

class Solution {
    public static int longestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int j = 0;
        int longest = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!seen.contains(s.charAt(i))) {
                seen.add(s.charAt(i));
                current++;
            } else {
                longest = Math.max(longest, current);
                while (seen.contains(s.charAt(i))) {
                    seen.remove(s.charAt(j));
                    j++;
                    current--;
                }
                seen.add(s.charAt(i));
                current++;
            }
        }
        return Math.max(longest, current);
    }

    public static void main(String[] args) {
        String a = "abcabcbb";
        String b = "bbbbb";
        String c = "pwwkew";
        String d = "paw";
        String e = "";
        String f = "abacd";

        System.out.println(longestSubstring(a));
        System.out.println(longestSubstring(b));
        System.out.println(longestSubstring(c));
        System.out.println(longestSubstring(d));
        System.out.println(longestSubstring(e));
        System.out.println(longestSubstring(f));
    }
}
