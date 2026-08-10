/* https://leetcode.com/problems/valid-anagram/description/
 * 242. Valid Anagram
 *
 * We can use a hash map to keep track of the number of each letter in the two strings,
 * then compare with .equals(). Since it is a given that the strings consist of only
 * lowercase english letters, using a fixed array of length 26 is slightly more
 * memory efficient.
 * If the input consisted of Unicode characters, we would use a hash
 * map of <Integer, Integer> using the code points, which is the integer ID of Unicode
 * characters, as keys because they can be either 1 or 2 charcters long.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // I'm choosing to use one array, adding the letters of s to it, then removing
        // the letters of t. Then I check if each letter == 0 at the end. Alternatively,
        // you can use two arrays and compare with Arrays.equals();
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int letter = s.charAt(i) - 97;
            map[letter]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int letter = t.charAt(i) - 97;
            map[letter]--;
        }

        for (int letter : map) {
            if (letter != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        String s1 = "rat", t1 = "car";
        String s2 = "job", t2 = "jobs";
        String s3 = "a", t3 = "a";
        String s4 = "a", t4 = "b";

        System.out.println(validAnagram(s, t));
        System.out.println(validAnagram(s1, t1));
        System.out.println(validAnagram(s2, t2));
        System.out.println(validAnagram(s3, t3));
        System.out.println(validAnagram(s4, t4));
    }
}
