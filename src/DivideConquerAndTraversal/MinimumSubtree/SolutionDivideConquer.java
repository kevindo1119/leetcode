package DivideConquerAndTraversal.MinimumSubtree;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */
// version 2 : pure divide conquer
public class SolutionDivideConquer {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        ResultType result = helper(root);
        return result.minSubtree;
    }

    ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(null, 0, Integer.MAX_VALUE);
        }
        // 获得左右子树的和
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);

        int minSum = Integer.MAX_VALUE;
        // 计算当前子树和，并更新答案
        int sum = root.val + leftResult.sum + rightResult.sum;

        minSum = Math.min(sum, leftResult.minSum);
        minSum = Math.min(minSum, rightResult.minSum);

        ResultType result = new ResultType(root, sum, sum);

        if (leftResult.minSum < result.minSum) {
            result.minSubtree = leftResult.minSubtree;
            result.minSum = leftResult.minSum;
        }

        if (rightResult.minSum < result.minSum) {
            result.minSubtree = rightResult.minSubtree;
            result.minSum = rightResult.minSum;
        }
        return result;
    }

    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        public int sum, minSum;
        public TreeNode minSubtree;

        public ResultType(TreeNode minSubtree, int sum, int minSum) {
            this.minSubtree = minSubtree;
            this.minSum = minSum;
            this.sum = sum;
        }
    }
}