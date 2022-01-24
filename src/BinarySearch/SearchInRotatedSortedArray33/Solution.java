package BinarySearch.SearchInRotatedSortedArray33;

public class Solution {
    /**
     * @param A:      an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int minLoc = findMin(A);

        if (minLoc == 0) {
            return binarySearch(A, 0, A.length - 1, target);
        }

        if (target <= A[A.length - 1]) {
            return binarySearch(A, minLoc, A.length - 1, target);
        } else {
            return binarySearch(A, 0, minLoc - 1, target);
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    private int findMin(int[] nums) {
        // write your code here
        int len = nums.length;
        int start = 0, end = len - 1;

        if (nums[start] < nums[end]) {
            return start;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[len - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return end;
    }
}
