/* https://leetcode.com/problems/smallest-stable-index-i/description/
 * 3903. Smallest Stable Index I
 *
 * Initial Approach
 * At every index i in nums, we find the min from [i, nums.length), and we build the max
 * from left to right as we iterate through nums. We check max - min <= k at every index
 * and return i if the index is stable.
 *
 * Time O(n^2), Space O(1)
 *
 * Optimal Approach:
 * We can build a suffix array that contains the min from [i, nums.length) for every
 * index i. Then we can build the max from left to right as we iterate through nums
 * and return the index if max - minSuffix[i] <= k.
 *
 * Time O(n), Space O(n)
 */

class Solution {
    // initial approach
    public static int smallestStableIndex(int[] nums, int k) {
        int i = 0;
        int max = nums[0];
        while (i < nums.length) {
            int min = nums[i];
            max = Math.max(nums[i], max);

            for (int j = i; j < nums.length; j++) {
                min = Math.min(nums[j], min);
            }

            if (max - min <= k) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // optimal approach
    public static int optimalSmallestStableIndex(int[] nums, int k) {
        int[] minSuffix = new int[nums.length];
        int min = nums[nums.length - 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minSuffix[i] = min;
        }

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max - minSuffix[i] <= k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 0, 1, 4};
        int[] b = {3, 2, 1};
        int[] c = {0};
        int k1 = 3, k2 = 1, k3 = 0;

        System.out.println(smallestStableIndex(a, k1));
        System.out.println(smallestStableIndex(b, k2));
        System.out.println(smallestStableIndex(c, k3));
        
        System.out.println(optimalSmallestStableIndex(a, k1));
        System.out.println(optimalSmallestStableIndex(b, k2));
        System.out.println(optimalSmallestStableIndex(c, k3));
    }
}
