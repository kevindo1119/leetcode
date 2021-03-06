package BinarySearch.SearchA2dMatrix74;


        /*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of the previous row. For example,

        Consider the following matrix:

        [ 1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 50 ] Given target = 3, return true.

        可以看作是一个有序数组被分成了n段，每段就是一行。因此依然可以二分求解。 对每个数字，根据其下标i，j进行编号，每个数字可被编号为0～n*n-1

        相当于是在一个数组中的下标。然后直接像在数组中二分一样来做。取的mid要还原成二位数组中的下标，i = mid/n, j = mid%n*/


// Binary Search Once
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0, end = row * column - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int number = matrix[mid / column][mid % column];
            if (number == target) {
                return true;
            } else if (number > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;

    }
}
