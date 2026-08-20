/* https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 * 150. Evaluate Reverse Polish Notation
 *
 * When we find an operator, we want to apply the operator on the two most recent
 * numbers. We can use a stack to keep track of the most recent seen numbers as well as
 * push the new number onto the top of the stack. We loop through the array checking each
 * value. If the value is an operator, we apply the operation to the two most recent
 * numbers and push the new number onto the stack. If the value is not an operator, it
 * must be a number and we can push it onto the stack. At the end, we return the last
 * value in the stack.
 *
 * Time O(n), Space O(n)
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static int evaluateRevPolishNotation(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.poll();
    }

    public static void main(String[] args) {
        String[] a = {"2", "1", "+", "3", "*"};
        String[] b = {"4", "13", "5", "/", "+"};
        String[] c = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        String[] d = {"1", "2", "+"};

        System.out.println(evaluateRevPolishNotation(a));
        System.out.println(evaluateRevPolishNotation(b));
        System.out.println(evaluateRevPolishNotation(c));
        System.out.println(evaluateRevPolishNotation(d));
    }
}
