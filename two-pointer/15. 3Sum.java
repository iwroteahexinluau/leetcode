/* https://leetcode.com/problems/3sum/description/
 * 15. 3Sum
 *
 * We can loop through the array, using two pointers to check every possible combination.
 * We can set the pointers at left = i + 1 and right = nums.length - 1. In order to
 * prevent duplicate triplets, we have to sort the array and make sure that when looping
 * through the array, our starting index of nums[i] != nums[i - 1]. Then, after finding a
 * solution, we move the two pointers until they are different values. Since the array is
 * sorted, we know that when checking the sum of the three values, that if the sum > 0,
 * we should move the right pointer, otherwise we should move the left pointer.
 *
 * Time O(n^2), Space O(1)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> sum = new ArrayList<>();
                    sum.add(nums[i]);
                    sum.add(nums[left]);
                    sum.add(nums[right]);
                    sums.add(sum);

                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        int[] b = {0, 1, 1};
        int[] c = {0, 0, 0};
        int[] d = {1, -2, 0};
        int[] e = {-2, -1, -1, 0, 1, 2};
        int[] f = {-2, 0, 1, 1, 2};

        System.out.println(threeSum(a));
        System.out.println(threeSum(b));
        System.out.println(threeSum(c));
        System.out.println(threeSum(d));
        System.out.println(threeSum(e));
        System.out.println(threeSum(f));
    }
}
