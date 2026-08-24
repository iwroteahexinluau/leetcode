/* https://leetcode.com/problems/majority-element/description/
 * 169. Majority Element
 *
 * Boyer-Moore Algorithm:
 * If a majority element (appears more than n / 2) exists in the array, we can use
 * the Boyer-Moore algorithm to find it. We start by setting the candidate = nums[0] and
 * track the count of candidate. Then we loop through the array and if nums[i] ==
 * candidate, we increment count, otherwise if nums[i] != candidate, we decrement count.
 * If count == 0, we switch the candidate to nums[i].
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate || count == 0) {
                candidate = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 3};
        int[] b = {2, 2, 1, 1, 1, 2, 2,};

        System.out.println(majorityElement(a));
        System.out.println(majorityElement(b));
    }
}
