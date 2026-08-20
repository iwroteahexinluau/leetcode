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
 * until pos == n. The recursion stack adds O(1) space per call, O(n) space total.
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
    public static String recursiveCountAndSay(int n, int pos, StringBuilder rle) {
        if (n == 1 || pos == n) {
            return rle.toString();
        }
        StringBuilder sequence = new StringBuilder();
        int count = 1;
        for (int i = 0; i < rle.length(); i++) {
            if (i == rle.length() - 1 || rle.charAt(i) != rle.charAt(i + 1)) {
                sequence.append(count);
                sequence.append(rle.charAt(i));
                count = 1;
            } else {
                count++;
            }
        }
        return recursiveCountAndSay(n, pos + 1, sequence);
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

        StringBuilder base = new StringBuilder("1");
        System.out.println(recursiveCountAndSay(a, 1, base));
        System.out.println(recursiveCountAndSay(b, 1, base));
        System.out.println(recursiveCountAndSay(c, 1, base));
        System.out.println(recursiveCountAndSay(d, 1, base));
        System.out.println(recursiveCountAndSay(e, 1, base));
    }
}
