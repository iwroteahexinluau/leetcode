/* https://leetcode.com/problems/container-with-most-water/description/
 * 11. Container With Most Water
 *
 * We start with two pointers with left = 0 and right = height.length - 1. We know that
 * the only way for the maximum amount of water to be higher than the current water is if
 * the limiting height (the lower height) increases. We take the greedy approach of
 * moving the pointer that is at the lower height. If the two heights are equivalent,
 * it does not matter which pointer we move as any new height found will not cause the
 * current water to be bigger than the max until both pointers have found a new height.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int mostWater(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int mostWater = 0;
        while (left < right) {
            int currentWater = Math.min(height[left], height[right]) * (right - left);
            mostWater = Math.max(currentWater, mostWater);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return mostWater;
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] b = {1, 1};
        int[] c = {1, 8, 2, 2, 100, 2, 8, 1};

        System.out.println(mostWater(a));
        System.out.println(mostWater(b));
        System.out.println(mostWater(c));
    } 
}
