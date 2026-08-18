/* https://leetcode.com/problems/reverse-string-ii/description/
 * 541. Reverse String II
 *
 * We turn string s into a char array of all its characters, then loop through the array
 * at intervals of 2k. At each interval, the range is either k, or the remaining
 * characters left if they are fewer than k. We reverse the interval keeping track of
 * the left bound i + j and the right bound i + range - j - 1.
 *
 * Time O(n), Space O(n)
 */

class Solution {
    public static String reverseString2(String s, int k) {
        if (s.length() == 1 || k == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int range = k;
            // in case there are fewer than k characters left, reverse the rest
            if (s.length() - i < k) {
                range = s.length() - i;
            }
            int j = 0;
            while (j < range / 2) {
                char temp = chars[i + j];
                chars[i + j] = chars[i + range - j - 1];
                chars[i + range - j - 1] = temp;
                j++;
            }
        }
       return new String(chars);
    }

    public static void main(String[] args) {
        String s1 = "abcdefg";
        int k1 = 1, k2 = 2, k3 = 3, k4 = 4;
        String s2 = "abcd";
        String s3 = "abc";
        String s4 = "abcde";

        System.out.println(reverseString2(s1, k1));
        System.out.println(reverseString2(s1, k2));
        System.out.println(reverseString2(s1, k4));
        System.out.println(reverseString2(s2, k2));
        System.out.println(reverseString2(s2, k3));
        System.out.println(reverseString2(s2, k4));
        System.out.println(reverseString2(s3, k2));
        System.out.println(reverseString2(s4, k4));
        System.out.println(reverseString2(s1, k3));
    }
}
