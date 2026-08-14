/* https://leetcode.com/problems/valid-parentheses/description/
 * 20. Valid Parentheses
 *
 * We can add all open brackets to a stack. When we reach a closing bracket, and the
 * stack is not empty, we can check if the closing bracket matches the most recent
 * open bracket. If it does, we pop the stack and continue. After looping through the
 * string, we check to make sure that the stack is empty.
 *
 * Time O(n), Space O(n)
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static boolean validParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else if (stack.peek() == null) {
                return false;
            } else {
                if (s.charAt(i) == ')' && stack.peek() != '(') {
                    return false;
                } else if (s.charAt(i) == ']' && stack.peek() != '[') {
                    return false;
                } else if (s.charAt(i) == '}' && stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String a = "()";
        String b = "()[]{}";
        String c = "(]";
        String d = "([])";
        String e = "([)]";
        String f = "(";
        String g = "]";

        System.out.println(validParentheses(a));
        System.out.println(validParentheses(b));
        System.out.println(validParentheses(c));
        System.out.println(validParentheses(d));
        System.out.println(validParentheses(e));
        System.out.println(validParentheses(f));
        System.out.println(validParentheses(g));
    }
}
