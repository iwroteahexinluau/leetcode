/* https://leetcode.com/problems/unique-3-digit-even-numbers/description/
 * 3483. Unique 3-Digit Even Numbers
 *
 * We can use a frequency array to track the number of each digit we have from the digits
 * array. Then we can loop through every even 3 digit number (100, 102, ..., 998) and
 * check if we have enough digits to make that number.
 *
 * Time O(n), Space O(1)
 * Building the frequency array is time O(n). Check every even 3 digit numbes is time
 * O(1) because there are only 450 possibilities. The space is O(1) because both
 * frequency arrays are size 10.
 */

class Solution {
    public static int unique3DigitEvenNumbers(int[] digits) {
        int[] freq = new int[10];

        for (int i = 0; i < digits.length; i++) {
            freq[digits[i]]++;
        }

        int count = 0;
        for (int i = 100; i <= 998; i += 2) {
            int num = i;
            int[] numFreq = new int[10];
            while (num > 0) {
                numFreq[num % 10]++;
                num /= 10;
            }
            boolean isValid = true;
            for (int j = 0; j < freq.length; j++) {
                if (numFreq[j] > freq[j]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {0, 2, 2};
        int[] c = {6, 6, 6};
        int[] d = {1, 3, 5};

        System.out.println(unique3DigitEvenNumbers(a));
        System.out.println(unique3DigitEvenNumbers(b));
        System.out.println(unique3DigitEvenNumbers(c));
        System.out.println(unique3DigitEvenNumbers(d));
    }
}
