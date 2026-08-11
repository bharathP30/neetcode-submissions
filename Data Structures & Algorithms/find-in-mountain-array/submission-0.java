/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr.length() < 3)
            return -1;

        int n = mountainArr.length();
        int peak = findMountainPeak(mountainArr, n - 1);

        int found = binarySearch(mountainArr, 0, peak, target, true);

        if (found != -1)
            return found;
        return binarySearch(mountainArr, peak + 1, n - 1, target, false);
    }

    public int findMountainPeak(MountainArray mountainArr, int high) {
        int low = 0;
        while (low < high) {
            int mid = (low + high) >>> 1;

            if (mountainArr.get(mid) > mountainArr.get(mid + 1))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    public int binarySearch(
        MountainArray mountainArr, int low, int high, int target, boolean isAsc) {
        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (mountainArr.get(mid) == target)
                return mid;

            if (isAsc) {
                if (mountainArr.get(mid) > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (mountainArr.get(mid) > target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}