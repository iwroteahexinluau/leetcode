/* https://leetcode.com/problems/find-the-largest-almost-missing-integer/description/
 * 3471. Find the Largest Almost Missing Integer
 *
 * We can observe that if 1 < k < nums.length, the only valid positions that will appear
 * in exactly one subarray, are the integers at nums[0] and nums[nums.length - 1]. If
 * k == 1, each index is its own subarray, so we want to find the largest element that 
 * only appears once. If k == nums.length, there is only one subarray, so we want to find
 * the largest element. Since the constraints of nums[i] are 0 <= nums[i] <= 50, we can 
 * build a frequency array as we loop through nums and track the frequency of each
 * number. Then, we loop from 50 to 0 looking for the first integer that has been seen
 * only once or the largest integer depending on k. If 1 < k < nums.length, we check if 
 * nums[0] and nums[nums.length - 1] is valid, and return the largest valid integer
 * between the two, otherwise -1 if they are both invalid.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int findLargestAlmostMissing(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }

        // build the frequency array
        int[] seen = new int[51];
        for (int i = 0; i < nums.length; i++) {
            seen[nums[i]]++;
        }
        // handle if k == 1 or k == nums.length
        if (k == 1 || k == nums.length) {
            for (int i = 50; i >= 0; i--) {
                if (k == 1 && seen[i] == 1 || k == nums.length && seen[i] > 0) {
                    return i;
                }
            }
            return -1;
        }

        // handle 1 < k < nums.length
        int largest = Math.max(nums[0], nums[nums.length - 1]);
        int smallest = Math.min(nums[0], nums[nums.length - 1]);
        if (seen[largest] == 1) {
            return largest;
        } else if (seen[smallest] == 1) {
            return smallest;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 9, 2, 1, 7};
        int k1 = 3;
        int[] b = {3, 9, 7, 2, 1, 7};
        int k2 = 4;
        int[] c = {0, 0};
        int k3 = 1;
        int k4 = 6;
        int[] d = {2, 2};
        int k5 = 2;

        System.out.println(findLargestAlmostMissing(a, k1));
        System.out.println(findLargestAlmostMissing(b, k2));
        System.out.println(findLargestAlmostMissing(c, k3));
        System.out.println(findLargestAlmostMissing(b, k4));
        System.out.println(findLargestAlmostMissing(d, k5));
    }
}
