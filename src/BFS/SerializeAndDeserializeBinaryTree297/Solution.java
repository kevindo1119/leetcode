package BFS.SerializeAndDeserializeBinaryTree297;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        List<String> result = new ArrayList();
        if (root == null) {
            return "[]";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        result.add(Integer.toString(root.val));
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head.left != null) {
                queue.offer(head.left);
                result.add(Integer.toString(head.left.val));
            } else {
                result.add("#");
            }

            if (head.right != null) {
                queue.offer(head.right);
                result.add(Integer.toString(head.right.val));
            } else {
                result.add("#");
            }
        }

        String resultString = "[" + String.join(",", result) + "]";

        return resultString;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0 || data == "[]") {
            return null;
        }
        List<String> allNodes = Arrays.asList(data.substring(1, data.length() - 1).split(","));

        List<TreeNode> binaryTreeSeen = new ArrayList();
        binaryTreeSeen.add(new TreeNode(Integer.parseInt(allNodes.get(0))));
        int parentIndex = 0;
        int childIndex = 1;
        while (parentIndex < binaryTreeSeen.size() && childIndex < allNodes.size()) {
            String emptyValue = "#";

            // leftChild
            TreeNode leftChild;
            if (emptyValue.equals(allNodes.get(childIndex))) {
                leftChild = null;
            } else {
                leftChild = new TreeNode(Integer.parseInt(allNodes.get(childIndex)));
                binaryTreeSeen.add(leftChild);
            }
            childIndex = childIndex + 1;

            // rightChild
            TreeNode rightChild;
            if (emptyValue.equals(allNodes.get(childIndex))) {
                rightChild = null;
            } else {
                rightChild = new TreeNode(Integer.parseInt(allNodes.get(childIndex)));
                binaryTreeSeen.add(rightChild);
            }
            childIndex = childIndex + 1;

            // add bothChild to parent
            TreeNode parentNode = binaryTreeSeen.get(parentIndex);
            parentNode.left = leftChild;
            parentNode.right = rightChild;
            parentIndex = parentIndex + 1;

        }

        return binaryTreeSeen.get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
