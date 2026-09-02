/* https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/
 * 3090. Maximum Length Substring With Two Occurences
 *
 * We can use a sliding window and a frequency array to keep track of the current valid
 * substring that contains at most two occurences of each character. When we reach a
 * letter that makes the letter count of that letter exceed 2, we remove the character at
 * the left pointer and move the left pointer until the window is valid again. Once a
 * window is valid, we check if it is a new maximum length substring.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int maxLengthSubstring(String s) {
        int[] letters = new int[26];
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            int letterInt = s.charAt(right) - 'a';
            letters[letterInt]++;
            while (letters[letterInt] > 2) {
                int leftLetter = s.charAt(left) - 'a';
                letters[leftLetter]--;
                left++;
            }
            right++;
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String a = "bcbbbcba";
        String b = "aaaa";

        System.out.println(maxLengthSubstring(a));
        System.out.println(maxLengthSubstring(b));
    }
}
