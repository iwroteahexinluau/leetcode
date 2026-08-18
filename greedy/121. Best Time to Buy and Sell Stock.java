/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 121. Best Time to Buy and Sell Stock
 *
 * We want to find the biggest difference where the bigger number appears later in the
 * array. We can greedily pick the lowest number we come across, and compare the
 * difference with our previous best difference.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int bestTimeToBuy(int[] nums) {
        int lowest = nums[0];
        int difference = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= lowest) {
                difference = Math.max(difference, nums[i] - lowest);
            } else {
                lowest = nums[i];
            }
        }
        return difference;
    }

    public static void main(String[] args) {
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {7, 6, 4, 3, 1};
        int[] c = {5, 7};
        int[] d = {20, 40, 1, 19, 100};

        System.out.println(bestTimeToBuy(a));
        System.out.println(bestTimeToBuy(b));
        System.out.println(bestTimeToBuy(c));
        System.out.println(bestTimeToBuy(d));
    }
}
