/* https://leetcode.com/problems/longest-common-prefix/description/
 * 14. Longest Common Prefix
 *
 * Since the longest common prefix amongst strings will be at max the length of the
 * shortest string, we can find the shortest string to determine our loop. Then, we loop
 * through the characters, checking if they match the characters in strs[0]. If they do
 * not match, immediately return the current prefix. If they all match, add to the prefix
 * and move to the next position.
 *
 * Time O(n * m), Space O(1)
 * m = length of the shortest string
 */

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        // if only one string, the entire string is a valid prefix
        if (strs.length == 1) {
            return strs[0];
        }

        // loop through strs to find the shortest string
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            shortest = Math.min(shortest, strs[i].length());
        }

        int i = 0;
        while (i < shortest) {
            char letter = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != letter) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
        return strs[0].substring(0, shortest);
    }

    public static void main(String[] args) {
        String[] a = {"flower", "flow", "flight"};
        String[] b = {"dog", "racecar", "car"};
        String[] c = {"dog", "dog", "dog"};
        String[] d = {"help"};

        System.out.println(longestCommonPrefix(a));
        System.out.println(longestCommonPrefix(b));
        System.out.println(longestCommonPrefix(c));
        System.out.println(longestCommonPrefix(d));
    }
}
