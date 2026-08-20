/* https://leetcode.com/problems/maximum-average-subarray-i/description/
 * 643. Maximum Average Subarray I
 *
 * Initial Approach:
 * We can loop through nums, and at each position check the average of the window of
 * length k. We keep track of the maximum average we have seen. This is inefficient and
 * has time O(n^2) because at each position we are looping k times.
 *
 * Time O(n^2), Space O(1)
 *
 * Optimal Approach:
 * We can keep track of the sum of the k window, and as we loop through nums we subtract
 * the left pointer of the window and add the next num. This way we can avoid rebuilding
 * the entire sum and average of the window everytime, and can just check the average.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    // initial approach
    public static double maximumAverageSubarray1(int[] nums, int k) {
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < nums.length - k + 1; i++) {
            double average = 0;
            for (int j = i; j < i + k; j++) {
                average += nums[j];
            }
            average /= k;
            max = Math.max(max, average);
        }
        return max;
    }
    // optimized approach
    public static double optimizedMaximumAverage(int[] nums, int k) {
        // build the initial window sum
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum / k;
        for (int i = 1; i < nums.length - k + 1; i++) {
            sum -= nums[i - 1];
            sum += nums[i + k - 1];
            max = Math.max(max, sum / k);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 12, -5, -6, 50, 3};
        int[] b = {5};
        int[] c = {-1};
        int[] d = {-5, -2, -3};
        int k1 = 4, k2 = 1, k3 = 2;

        System.out.println(maximumAverageSubarray1(a, k1));
        System.out.println(maximumAverageSubarray1(b, k2));
        System.out.println(maximumAverageSubarray1(c, k2));
        System.out.println(maximumAverageSubarray1(d, k3));

        System.out.println(optimizedMaximumAverage(a, k1));
        System.out.println(optimizedMaximumAverage(b, k2));
        System.out.println(optimizedMaximumAverage(c, k2));
        System.out.println(optimizedMaximumAverage(d, k3));
    }
}
