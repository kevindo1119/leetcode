package BFS.NumberOfIslands200;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int i, int j) {
        x = i;
        y = j;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean inBound(boolean[][] visited) {
        return x >= 0 && x < visited.length && y >= 0 && y < visited[0].length;
    }
}
