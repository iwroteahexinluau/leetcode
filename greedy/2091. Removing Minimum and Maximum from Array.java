/* https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/
 * 2091. Removing Minimum and Maximum from Array
 *
 * We can loop through the array and find the minimum and maximum values along with their
 * index position. With the two index positions there are 3 scenarios to determine what
 * the minimum number of deletions it would take to remove both elements. The two
 * elements can either be removed from the left side, the right side, or be removed from
 * separate sides. We can find the number of deletions from the left side by checking the 
 * furthest element + 1, and the number of deletions from the right side by checking
 * nums.length - closest. We then compare with the the number of deletions it would take
 * to delete from both sides, closest + 1 + nums.length - furthest, and take the smallest
 * of the 3 values.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int removeMinAndMax(int[] nums){
        if (nums.length == 1) {
            return 1;
        }
        int min = nums[0];
        int minIndex = 0;
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        int furthest = Math.max(minIndex, maxIndex);
        int closest = Math.min(minIndex, maxIndex);
        int fromOneSide = Math.min(furthest + 1, nums.length - closest);
        int fromBothSides = closest + 1 + nums.length - furthest;
        return Math.min(fromOneSide, fromBothSides);
    }

    public static void main(String[] args) {
        int[] a = {2, 10, 7, 5, 4, 1, 8, 6};
        int[] b = {0, -4, 19, 1, 8, -2, -3, 5};
        int[] c = {101};
        int[] d = {0, 1, 2};

        System.out.println(removeMinAndMax(a));
        System.out.println(removeMinAndMax(b));
        System.out.println(removeMinAndMax(c));
        System.out.println(removeMinAndMax(d));

    }
}
