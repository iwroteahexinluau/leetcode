/* https://leetcode.com/problems/find-in-mountain-array/description/
 * 1095. Find in Mountain Array
 *
 * The lowest index of the target could be on the increasing side of the peak element or
 * on the decreasing side of the peak element. We can do three binary searches to first
 * find the peak element, then search from [0, peak) and [peak, mountainArr.length).
 *
 * Time O(log n), Space O(1)
 */

interface MountainArrayInterface {
    int get(int index);
    int length();
}

class MountainArray implements MountainArrayInterface {
    private int[] array;

    public MountainArray(int[] array) {
        this.array = array;
    }

    @Override
    public int get(int index) {
        return this.array[index];
    }

    @Override
    public int length() {
        return this.array.length;
    }
}

class Solution {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int low = 0;
        int length = mountainArr.length();
        int high = length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int peak = low;
        high = peak;
        low = 0;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);
            if (value == target) {
                // if we find target in the left side, it is guaranteed to be the lowest index
                return mid;
            } else if (value < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        low = peak;
        high = length; // high = length because the loop breaks at low == high, so we
                       // never actually check if target == mountainArr[high].

        while (low < high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);
            if (value == target) {
                return mid;
            } else if (value > target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 3, 1};
        int t1 = 3;
        MountainArray mountain1 = new MountainArray(a);
        System.out.println(findInMountainArray(t1, mountain1));

        int[] b = {0, 1, 2, 4, 2, 1};
        int t2 = 3;
        MountainArray mountain2 = new MountainArray(b);
        System.out.println(findInMountainArray(t2, mountain2));

        int[] c = {1, 5, 4, 3, 2};
        int t3 = 3;
        MountainArray mountain3 = new MountainArray(c);
        System.out.println(findInMountainArray(t3, mountain3));

        int[] d = {1, 3, 5, 4, 3, 2};
        int t4 = 1;
        MountainArray mountain4 = new MountainArray(d);
        System.out.println(findInMountainArray(t4, mountain4));

        int[] e = {1, 3, 5, 4, 2};
        int t5 = 2;
        MountainArray mountain5 = new MountainArray(e);
        System.out.println(findInMountainArray(t5, mountain5));
    }
}
