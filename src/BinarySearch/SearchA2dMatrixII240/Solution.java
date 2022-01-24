package BinarySearch.SearchA2dMatrixII240;

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: A number you want to search in the matrix
     * @return : An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        // 从左下角开始，往右上角逼近
        int r = matrix.length - 1;
        int c = 0;
        int ans = 0;
        while (r >= 0 && c < matrix[0].length) {
            if (target == matrix[r][c]) {
                ans++;
                r--;
                c++;
                continue;
            }
            if (target < matrix[r][c]) {
                r--;
            } else {
                c++;
            }
        }
        return ans;
    }
}
