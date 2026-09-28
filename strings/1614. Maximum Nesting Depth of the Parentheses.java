/* https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
 * 1614. Maximum Nesting Depth of the Parentheses
 *
 * We can keep count of the maximum number of open parentheses that are not closed to
 * determine the max nesting depth.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "(1+(2*3)+((8)/4))+1";
        String b = "(1)+((2))+(((3)))";
        String c = "()(())((()()))";
        String d = "()";
        String e = "";
        String f = "(())";

        System.out.println(maxDepth(a));
        System.out.println(maxDepth(b));
        System.out.println(maxDepth(c));
        System.out.println(maxDepth(d));
        System.out.println(maxDepth(e));
        System.out.println(maxDepth(f));
    }
}
