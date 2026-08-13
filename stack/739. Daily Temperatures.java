/* https://leetcode.com/problems/daily-temperatures/description/
 * 739. Daily Temperatures
 *
 * We can use a stack to track the previous temperatures' index, with the lowest
 * temperatures added to the top. Since the array is guaranteed to have at least one element, we can
 * start by pushing the first index. Then we loop through the temperatures, checking if
 * the current temperature is warmer than the top of the stack. If it is, we can pop the
 * top of the stack and check the next temperature until it is not warmer or the stack is
 * empty. Then we push the current temperature index on the stack. If there are any
 * temperatures left in the stack, the array defaults them to 0, so no additional action
 * is required.
 *
 * Time O(n), Space O(n)
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int[] warmerDays = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            while (stack.peek() != null && temperatures[i] > temperatures[stack.peek()]) {
                warmerDays[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return warmerDays;
    }

    public static void main(String[] args) {
        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] b = {30, 40, 50, 60};
        int[] c = {30, 60, 90};

        System.out.println(Arrays.toString(dailyTemperatures(a)));
        System.out.println(Arrays.toString(dailyTemperatures(b)));
        System.out.println(Arrays.toString(dailyTemperatures(c)));
    }
}
