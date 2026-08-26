/* https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/
 * 2904. Shortest and Lexicographically Smallest Beautiful String
 *
 * We can use a sliding window to find the valid beautiful substrings. We loop through
 * the string using the right pointer to check each position, and if we find a 1 we add
 * to the count. Once we find a valid window (count == k), we move left to the next 1 to
 * make the window as small as possible. Then we create the substring from [left, right
 * + 1), and compare with our current smallest. We can use .compareTo() to find which
 * string is the lexicographically smallest if they have the same length. Then we
 * continue with the loop. If count > k, we move the left pointer past the next 1 to
 * check the next valid window.
 *
 * Time O(n^2), Space O(n)
 * For each valid beautiful substring, we are using .compareTo() which is O(n), so the
 * time complexity is O(n^2).
 */

class Solution {
    public static String beautifulString(String s, int k) {
        int left = 0, count = 0;
        String smallest = "";
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                count++;
            }
            while (count > k) {
                if (s.charAt(left) == '1') {
                    count--;
                }
                left++;
            }
            while (count == k && s.charAt(left) != '1') {
                left++;
            }
            if (count == k) {
                String substr = s.substring(left, right + 1);
                if (smallest.equals("") || substr.length() < smallest.length() || substr.length() == smallest.length() && smallest.compareTo(substr) > 0) {
                    smallest = substr;
                }
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        String a = "100011001";
        String b = "1011";
        String c = "000";
        String d = "1000110001";
        int k1 = 1, k2 = 2, k3 = 3;

        System.out.println(beautifulString(a, k3));
        System.out.println(beautifulString(b, k2));
        System.out.println(beautifulString(c, k1));
        System.out.println(beautifulString(d, k3));

    }
}
