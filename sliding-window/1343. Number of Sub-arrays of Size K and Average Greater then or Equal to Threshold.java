/* https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
 * 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 *
 * We can use a sliding window of size k to track the current sum at every position. With
 * the sum we can check if the average at that position is >= threshold, and if it is we
 * increment the count. When we shift the sliding window we remove the number at the left
 * position of the old window and add the new number that right pointer has moved to in
 * the new window. We can avoid coverting to a double and doing floating point division
 * to calculate the average by instead comparing sum with threshold * k.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int numberOfSubArrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum >= threshold * k) {
            count++;
        }
        for (int i = 1; i < arr.length - k + 1; i++) {
            sum -= arr[i - 1];
            sum += arr[i + k - 1];
            if (sum >= threshold * k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3, t = 4;
        int[] b = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k1 = 3, t1 = 5;
        int[] c = {1, 2};
        int k2 = 1, t2 = 3;

        System.out.println(numberOfSubArrays(a, k, t));
        System.out.println(numberOfSubArrays(b, k1, t1));
        System.out.println(numberOfSubArrays(c, k2, t2));
    }
}
