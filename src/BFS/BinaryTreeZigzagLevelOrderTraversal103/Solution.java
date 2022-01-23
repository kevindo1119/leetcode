package BFS.BinaryTreeZigzagLevelOrderTraversal103;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
        treeNodeQueue.offer(root);
        int currentLevel = 0;

        while (!treeNodeQueue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int treeNodeQueueSize = treeNodeQueue.size();

            for (int i = 0; i < treeNodeQueueSize; ++i) {
                TreeNode head = treeNodeQueue.poll();
                level.add(head.val);

                if (head.left != null) {
                    treeNodeQueue.offer(head.left);
                }

                if (head.right != null) {
                    treeNodeQueue.offer(head.right);
                }

            }
            if (currentLevel % 2 == 0) {
                result.add(level);
            } else {
                Collections.reverse(level);
                result.add(level);
            }

            currentLevel = currentLevel + 1;
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
