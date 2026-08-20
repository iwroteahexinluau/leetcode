/* https://leetcode.com/problems/count-and-say/description/
 * 38. Count and Say
 *
 * Iterative Approach:
 * We can start with the initial string of "1" and iterate n - 1 times, building the RLE
 * of the previous string every iteration.
 *
 * Time O(m), Space O(m)
 * m = length of countAndSay(n)
 *
 * Recursive Approach:
 * Very similar to the iterative approach, we start with the intial string of "1", and
 * build a new RLE of the previous string. We repeat and recursively call the function
 * until we find the last RLE of n - 1. The recursion stack adds O(1) space per call,
 * O(n) space total.
 *
 * Time O(m), Space O(m + n) = O(m)
 * m = length of countAndSay(n)
 */

class Solution {
    // iterative approach
    public static String countAndSay(int n) {
        StringBuilder sequence = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder newSequence = new StringBuilder();
            int count = 1;
            for (int j = 0; j < sequence.length(); j++) {
                if (j == sequence.length() - 1 || sequence.charAt(j) != sequence.charAt(j + 1)) {
                    newSequence.append(count);
                    newSequence.append(sequence.charAt(j));
                    count = 1;
                } else {
                    count++;
                }
            }
            sequence = newSequence;
        }
        return sequence.toString();
    }
    // recursive approach
    public static String RLE(String sequence) {
        StringBuilder sb = new StringBuilder();
        char[] nums = sequence.toCharArray();
        char current = nums[0];
        int count = 0;
        for (char num : nums) {
            if (num != current) {
                sb.append(count);
                sb.append(current);
                count = 1;
                current = num;
            } else {
                count++;
            }
        }
        sb.append(count);
        sb.append(current);
        return sb.toString();
    }

    public static String recursiveCountAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        return RLE(recursiveCountAndSay(n - 1));
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;

        System.out.println(countAndSay(a));
        System.out.println(countAndSay(b));
        System.out.println(countAndSay(c));
        System.out.println(countAndSay(d));
        System.out.println(countAndSay(e));

        System.out.println(recursiveCountAndSay(a));
        System.out.println(recursiveCountAndSay(b));
        System.out.println(recursiveCountAndSay(c));
        System.out.println(recursiveCountAndSay(d));
        System.out.println(recursiveCountAndSay(e));
    }
}
