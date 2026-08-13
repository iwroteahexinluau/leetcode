/* https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/description/
 * 2240. Number of Ways to Buy Pens and Pencils
 *
 * We can find the distinct ways by finding the different amount of pencils you can buy
 * with each number of pens. Instead of doing a nested loop to count the pencils, we can
 * divide the remaining total by the price of a pencil, then adding 1. We add 1 because
 * you can buy 0 amount of pencils with each number of pens.
 *
 * Time O(n), Space O(1)
 * n = total / cost1 which is total worst case
 */

class Solution {
    public static long numWaysToBuy(int total, int cost1, int cost2) {
        long count = 0;
        for (int i = 0; i <= total; i += cost1) {
            count += (total - i) / cost2 + 1;
        }
        return count;

    }

    public static void main(String[] args) {
        int t = 20, c = 10, co = 5;
        int t1 = 5, c1 = 10, co1 = 10;
        int t2 = 1000000, c2 = 1, co2 = 1;

        System.out.println(numWaysToBuy(t, c, co));
        System.out.println(numWaysToBuy(t1, c1, co1));
        System.out.println(numWaysToBuy(t2, c2, co2));
    }
}
