package BinarySearch.FindFirstAndLastPositionOfElementInSortedArray34;

public class Solution {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    // 寻找左端点
    static int findFirstTargetNum(int[] A, int target, int n){
        int left = 0, right = n - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (A[mid] < target){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if (left < n && A[left] == target){
            return left;
        }
        if (right >= 0 && A[right] == target){
            return right;
        }
        return -1;
    }

    // 寻找右端点
    static int findLastTargetNum(int[] A, int target, int n){
        int left = 0, right = n - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (A[mid] <= target){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        if (right >= 0 && A[right] == target){
            return right;
        }
        if (left < n && A[left] == target){
            return left;
        }
        return -1;
    }

    public int[] searchRange(int[] A, int target) {
        int n = A.length;
        int[] interval = {-1, -1};
        interval[0] = findFirstTargetNum(A, target, n);
        interval[1] = findLastTargetNum(A, target, n);
        return interval;
    }
}
