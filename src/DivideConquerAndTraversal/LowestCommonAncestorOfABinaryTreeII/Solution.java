package DivideConquerAndTraversal.LowestCommonAncestorOfABinaryTree;

import java.util.ArrayList;

/**
 * Definition of ParentTreeNode:
 * <p>
 * class ParentTreeNode {
 * public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }
    // 方法1. 有 parent 指针的时候，两个分别向上走，把parent都记下来。做成了两个array， 这两个array从后向前看，找到不同的，最后一次在一起的就是答案
    // [A a b c d] [B h g f e c d]
    // 方法2. 先算出两个的层数，让层数低的先走到同一高度，再同时走，直到same parent

    /**
     * @param root: The root of the tree
     * @param A,    B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        ArrayList<ParentTreeNode> pathA = getPath2Root(A);
        ArrayList<ParentTreeNode> pathB = getPath2Root(B);

        int indexA = pathA.size() - 1;
        int indexB = pathB.size() - 1;

        ParentTreeNode lowestAncestor = null;
        while (indexA >= 0 && indexB >= 0) {
            if (pathA.get(indexA) != pathB.get(indexB)) {
                break;
            }
            lowestAncestor = pathA.get(indexA);
            indexA--;
            indexB--;
        }

        return lowestAncestor;
    }

    private ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node) {
        ArrayList<ParentTreeNode> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        return path;
    }
}
