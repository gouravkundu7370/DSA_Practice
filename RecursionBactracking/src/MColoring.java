import java.util.Arrays;

public class MColoring {
    public static void main(String[] args) {

        boolean[][] graph = new boolean[4][4];
        graph[0][1] = true;
        graph[0][2] = true;
        graph[1][2] = true;
        graph[2][3] = true;
        graph[3][0] = true;
          
       System.out.println( graphColoring(graph, 3, 4));
          

    }

    public static boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int[] color = new int[n];
        Arrays.fill(color, -1);
        return solve(graph, color, m, n, 0);
    }

    public static boolean solve(boolean[][] graph, int[] color, int m, int n, int node) {
        if (node == n) {
            return true;
        }
        for (int i = 1; i <= m; i++) {
            if (isSafe(graph, n, color, node, i)) {
                color[node] = i;
                if (solve(graph, color, m, n, node + 1)) {
                    return true;
                }
                color[node] = -1;
            }
        }
        return false;
    }

    public static boolean isSafe(boolean[][] graph, int n, int[] color, int node, int i) {
        for (int j = 0; j < n; j++) {
            if (graph[node][j] == true && color[j] == i) {

                return false;
            }
        }
        return true;
    }
}
