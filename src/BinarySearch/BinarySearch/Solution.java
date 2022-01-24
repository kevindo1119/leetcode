package BinarySearch.BinarySearch;

public class Solution {
    int binarySearch(int[] nums, int target) {
        // corner case 处理
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        // 要点1: start + 1 < end
        // 什么时候结束while？ start + 1 = end OR start = end
        // 这个while只是帮助缩小范围，保证答案在[start, end]
        while (start + 1 < end) {
            // 要点2：start + (end - start) / 2
            // 巧妙的防止内存爆掉 start = 2^30, end=2^31-1
            int mid = start + (end - start) / 2;
            // 要点3：=, <, > 分开讨论，mid 不 +1 也不 -1
            if (nums[mid] == target) {
                // 第一次出现target
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // 要点4: 循环结束后，单独处理start和end
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
