/* https://leetcode.com/problems/generate-parentheses/description/
 * 22. Generate Parentheses
 *
 * We can approach this problem using recursive backtracking while keeping track of the
 * number of open and closed parentheses. If the number of open parentheses < n, we add
 * an open parentheses, and recursively call the function again with the updated string
 * and open count. Then, we backtrack and remove the open parentheses. We then check if
 * the number of closed parentheses < open. If it is, we add a closed parentheses and
 * recursively call the function, removing the closed parentheses afterwards. When the
 * number of closed parentheses == n, we know that path has finished and we can add the
 * combination to the list.
 *
 * Time O(n * Cn), Space O(n)
 * n = number of parenthesis pairs, Cn = the nth Catalan number, which tells us how many
 * valid parentheses combinations exist for n pairs
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void generateParentheses(int n, StringBuilder current, int open, int closed, List<String> combinations) {
        if (closed == n) {
            combinations.add(current.toString());
            return;
        }
        if (open < n) {
            current.append('(');
            generateParentheses(n, current, open + 1, closed, combinations);
            current.deleteCharAt(current.length() - 1);
        }
        if (closed < open) {
            current.append(')');
            generateParentheses(n, current, open, closed + 1, combinations);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        int[] n = {3, 2, 1, 4};

        for (int i = 0; i < n.length; i++) {
            List<String> combinations = new ArrayList<>();
            StringBuilder current = new StringBuilder();
            generateParentheses(n[i], current, 0, 0, combinations);
            System.out.println(combinations);
        }
    }
}
