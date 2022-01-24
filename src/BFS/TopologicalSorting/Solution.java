package BFS.TopologicalSorting;
/*Graph
        For example:

        {1,2,4#2,1,4#3,5#4,1,2#5,3} represents follow graph:

        1------2  3
        \     |  |
        \    |  |
        \   |  |
        \  |  |
        4   5
        we use # to split each node information.
        1,2,4 represents that 2, 4 are 1's neighbors
        2,1,4 represents that 1, 4 are 2's neighbors
        3,5 represents that 5 is 3's neighbor
        4,1,2 represents that 1, 2 are 4's neighbors
        5,3 represents that 3 is 5's neighbor*/
/*输入：
graph = {0,1,2,3#1,4#2,4,5#3,4,5#4#5}
输出：
[0, 1, 2, 3, 4, 5]*/


import java.util.*;

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 * int label;
 * ArrayList<DirectedGraphNode> neighbors;
 * DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> order = new ArrayList<>();
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                } else {
                    indegree.put(neighbor, 1);
                }
            }
        }

        Queue<DirectedGraphNode> queue = new ArrayDeque<>();
        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
                order.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    order.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return order;
    }

    ;

    class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }
}
