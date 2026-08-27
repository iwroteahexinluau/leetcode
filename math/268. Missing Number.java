/* https://leetcode.com/problems/missing-number/description/
 * 268. Missing Number
 *
 * Standard Approach with Math:
 * We know that every number in [0, nums.length] exists besides one, so we can use a
 * formula to find the expected sum of whole numbers [0, nums.length] and subtract the 
 * actual sum we calculate while looping through nums to find the missing number.
 *
 * Time O(n), Space O(1)
 *
 * Alternative Approach with XOR:
 * We can XOR every number from O to n and XOR every number in nums because every number
 * that appears twice will cancel out, leaving only the missing number.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    // standard approach
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return (n * (n + 1)) / 2 - sum;
    }
    // alternative XOR approach
    public static int missingNumberXOR(int[] nums) {
        // start the XOR accumulation with n because the loop doesn't check n
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i;
            missing ^= nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] a = {3, 0, 1};
        int[] b = {0, 1};
        int[] c = {9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println(missingNumber(a));
        System.out.println(missingNumber(b));
        System.out.println(missingNumber(c));

        System.out.println(missingNumberXOR(a));
        System.out.println(missingNumberXOR(b));
        System.out.println(missingNumberXOR(c));
    }
}
