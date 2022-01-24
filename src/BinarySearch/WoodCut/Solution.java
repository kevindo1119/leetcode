package BinarySearch.WoodCut;

public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        int len_L = L.length;
        if (len_L == 0) {
            return 0;
        }
        int max_L = 0;//寻找最大值
        for (int i = 0; i < len_L; i++) {
            max_L = Math.max(max_L, L[i]);
        }
        long left = 0, right = max_L;
        int mid;
        while (left + 1 < right) {
            mid = (int) (left + (right - left) / 2);
            if (check(L, k, len_L, mid)) {//如果还能分更长的，则往[mid,right]走
                left = mid;
            } else {//如果不能分更长的，则往[left,mid]走
                right = mid;
            }
        }
        if (check(L, k, len_L, (int) right)) return (int) right;
        return (int) left;
    }

    private boolean check(int[] L, int k, int len_L, int mid) {
        int count = 0;
        //计算当前长度下能分成几段
        for (int i = 0; i < len_L; i++) {
            count += L[i] / mid;
        }
        //如果还能分更长的，返回true
        if (count >= k) {
            return true;
        }
        //如果不能分更长的，返回false
        return false;
    }
}
