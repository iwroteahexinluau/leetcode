/* https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 * 1358. Number of Substrings Containing All Three Characters
 *
 * We can use a sliding window to keep track of the valid window, and at each position
 * that we have a valid window, we add to the total number of substrings with s.length()
 * - right + 1 because every substring starting from that position to the end of the
 * string is a valid substring. After we found the valid window and added to substrings
 * count, we move the left pointer and remove the character in that position from the
 * frequency array to see if we can find another valid window.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int numberOfSubstrings(String s) {
        int[] letters = new int[3];
        int left = 0, right = 0;
        int substrings = 0;
        while(right < s.length()) {
            letters[s.charAt(right) - 'a']++;
            right++;
            while (letters[0] > 0 && letters[1] > 0 && letters[2] > 0) {
                substrings += s.length() - right + 1;
                letters[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return substrings;
    }

    public static void main(String[] args) {
        String a = "abcabc";
        String b = "aaacb";
        String c = "abc";

        System.out.println(numberOfSubstrings(a));
        System.out.println(numberOfSubstrings(b));
        System.out.println(numberOfSubstrings(c));

    }
}
