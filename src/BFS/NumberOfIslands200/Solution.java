package BFS.NumberOfIslands200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int numberOfIslands = 0;
        boolean[][] visited;
        visited = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                visited[i][j] = false;
            }
        }


        // baseCase
        if (grid == null || n == 0 || m == 0) {
            return 0;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    runBFS(grid, visited, i, j);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;

    }

    private static void runBFS(char[][] grid, boolean[][] visited, int i, int j) {
        int[] xCord = {-1, 1, 0, 0};
        int[] yCord = {0, 0, -1, 1};


        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Coordinate head = queue.poll();

            for (int index = 0; index < 4; index++) {
                Coordinate coordinate = new Coordinate(
                        head.getX() + xCord[index],
                        head.getY() + yCord[index]);

                if (!coordinate.inBound(visited)) {
                    continue;
                }

                if (!visited[coordinate.getX()][coordinate.getY()] && '1' == grid[coordinate.getX()][coordinate.getY()]) {
                    queue.offer(coordinate);
                    visited[coordinate.getX()][coordinate.getY()] = true;
                }
            }
        }
    }

    /* Driver program to test above function*/
    /*Input: grid = [
            ["1","1","1","1","0"],
            ["1","1","0","1","0"],
            ["1","1","0","0","0"],
            ["0","0","0","0","0"]
            ]
    Output: 1
    Input: grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
    ]
    Output: 3*/
    public static void main(String[] args) {
        char[][] grid;
        grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '1', '1', '0'};
        grid[1] = new char[]{'1', '1', '0', '1', '0'};
        grid[2] = new char[]{'1', '1', '0', '0', '0'};
        grid[3] = new char[]{'0', '0', '0', '0', '0'};

        System.out.println(numIslands(grid));

        char[][] grid2;
        grid2 = new char[4][5];
        grid2[0] = new char[]{'1', '1', '0', '0', '0'};
        grid2[1] = new char[]{'1', '1', '0', '0', '0'};
        grid2[2] = new char[]{'0', '0', '1', '0', '0'};
        grid2[3] = new char[]{'0', '0', '0', '1', '1'};

        System.out.println(numIslands(grid2));
    }

}
