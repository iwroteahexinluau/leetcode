/* https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * 424. Longest Repeating Character Replacement
 *
 * We can use a sliding window to keep track of our current valid window and the
 * frequency of the characters. Since s.length() >= 1, we can start by adding the
 * character at index 0, and since the input is only uppercase letters, we can use an
 * array of fixed size for tracking frequency. We add the character at the right pointer
 * to the frequency array. Then we check if the sliding window is valid. The sliding
 * window is valid if the number of non most frequent characters is <= k. We can find the
 * number of non most frequent characters by comparing the difference in the size of the
 * sliding window and the frequency of the most frequent number. If the window is not
 * valid, we remove the character at the left pointer from the frequency array, then move
 * the left pointer and check again. We do not have to recalculate maxFreq when moving
 * the left pointer because a new larger answer will not be found until maxFreq increases.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int longestRepeatingReplacement(String s, int k) {
        // s.length() >= 1, so we can start longest = 1 to catch the edge case of s.length == 1
        int longest = 1;
        int left = 0, right = 1;
        int[] seen = new int[26];
        seen[s.charAt(0) - 65]++;
        int maxFreq = 1;

        while (right < s.length()) {
            int letter = s.charAt(right) - 65;
            seen[letter]++;
            maxFreq = Math.max(maxFreq, seen[letter]);
            while (right - left + 1 - maxFreq > k) {
                seen[s.charAt(left) - 65]--;
                left++;
            }
            longest = Math.max(right - left + 1, longest);
            right++;
        }
        return longest;
    }

    public static void main(String[] args) {
        String s1 = "ABAB";
        int k1 = 2;
        String s2 = "AABABBA";
        int k2 = 1;
        String s3 = "AABAABBBBBBA";
        int k3 = 3;
        String s4 = "A";

        System.out.println(longestRepeatingReplacement(s1, k1));
        System.out.println(longestRepeatingReplacement(s2, k2));
        System.out.println(longestRepeatingReplacement(s3, k3));
        System.out.println(longestRepeatingReplacement(s4, k2));
    }
}
