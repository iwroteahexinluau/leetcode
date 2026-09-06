/* https://leetcode.com/problems/single-number/description/
 * 136. Single Number
 *
 * We can use the bitwise XOR operator on every number in the array to find the single
 * number that appears only once. The bitwise XOR operator checks each bit position of a
 * number and the resulting bit at that position is 1 when the two bits are different and
 * 0 when the two bits are the same. The useful properties of XOR here are
 * 0 ^ x = x
 * x ^ x = 0
 * Since we know every other element but the one we want to find appears twice, they will
 * cancel out leaving just x, the number that only appears once. XOR is also commutative
 * and associative (i.e. x ^ y = y ^ x and (x ^ y) ^ z = x ^ (y ^ z)), so it doesn't
 * matter if the duplicate elements are not next to each other.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int singleNumber(int[] nums) {
        int singleNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            singleNumber ^= nums[i];
        }
        return singleNumber;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 1};
        int[] b = {4, 1, 2, 1, 2};
        int[] c = {1};

        System.out.println(singleNumber(a));
        System.out.println(singleNumber(b));
        System.out.println(singleNumber(c));
    }
}
