package BFS.MinimumKnightMoves1197;

import BFS.NumberOfIslands200.Coordinate;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int minKnightMoves(int x, int y) {
        // In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].
        int[] cordX = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] cordY = {-2, -1, 1, 2, 2, 1, -1, -2};

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(0, 0));
        int step = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate current = queue.poll();
                if (current.getX() == x && current.getY() == y) {
                    return step;
                }

                for (int j = 0; j < 8; j++) {
                    Coordinate coordinate = new Coordinate(
                            current.getX() + cordX[j],
                            current.getY() + cordY[j]);

                    queue.offer(coordinate);
                }

            }
            step += 1;
        }
        return -1;

    }

    /* Driver program to test above function*/
    /*
    Example 1:

    Input: x = 2, y = 1
    Output: 1
    Explanation: [0, 0] → [2, 1]

    Example 2:

    Input: x = 5, y = 5
    Output: 4
    Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]*/
    public static void main(String[] args) {

        System.out.println(minKnightMoves(5, 5));
    }
}
