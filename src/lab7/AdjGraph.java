package lab7;

import java.util.ArrayDeque;
import java.util.Queue;

public class AdjGraph {

    private final int[][] matrix;
    private boolean directed = false;
    private int[] visited;

    public AdjGraph(int num) {
        matrix = new int[num][num];
    }

    public boolean isDirected() {
        return this.directed;
    }

    public void setDirected() {
        this.directed = true;
    }

    public String toString() {
        String result = "";
        for (int[] row : matrix) {
            for (int matrixValue : row) {
                result = result.concat(matrixValue + " ");
            }
            result = result.concat("\n");
        }
        return result;
    }

    public void addEdge(int x, int y) {
        matrix[x][y] = 1;
        if (!isDirected()) {
            matrix[y][x] = 1;
        }
    }

    public int degree(int x) {
        int degree = outDegree(x);
        if (isDirected()) {
            degree += inDegree(x);
        }
        return degree;
    }

    public int inDegree(int vert) {
        int in = 0;

        for (int row = 0; row < matrix[vert].length; row++) {
            if (matrix[row][vert] == 1) {
                in++;
            }
        }
        return in;
    }

    public int outDegree(int vert) {
        int out = 0;

        for (int column = 0; column < matrix[vert].length; column++) {
            if (matrix[vert][column] == 1) {
                out++;
            }
        }

        return out;
    }

    public void DFS() {
        // Default values for an int array are 0
        visited = new int[matrix.length];

        for (int vert = 0; vert < matrix.length; vert++) {
            if (visited[vert] != 1) {
                dfs(vert);
            }
        }
    }

    private void dfs(int y) {
        System.out.println("Visiting vertex: " + y);
        visited[y] = 1;
        for (int vert = 0; vert < matrix[y].length; vert++) {
            if (matrix[y][vert] == 1 && visited[vert] != 1) {
                dfs(vert);
            }
        }
    }

    public void BFS() {
        // Default values for an int array are 0
        visited = new int[matrix.length];

        for (int vert = 0; vert < matrix.length; vert++) {
            if (visited[vert] != 1) {
                bfs(vert);
            }
        }
    }

    private void bfs(int y) {
        Queue<Integer> q = new ArrayDeque<>();
        System.out.println("Visiting vertex: " + y);
        visited[y] = 1;
        q.add(y);
        while (!q.isEmpty()) {
            int node = q.peek();
            for (int vert = 0; vert < matrix[node].length; vert++) {
                if (matrix[node][vert] == 1 && visited[vert] != 1) {
                    System.out.println("Visiting vertex: " + vert);
                    visited[vert] = 1;
                    q.add(vert);
                }
            }
            q.remove();
        }
    }
}
