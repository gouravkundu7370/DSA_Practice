public class UniquePaths {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(4,4));
    }

    
    public static int uniquePaths1(int m, int n) {
        int ans = countPaths(0, 0, m, n);
        return ans;
           
    }

// Recursive
private static int countPaths(int i, int j, int m, int n) {
    if (i == m - 1 && j == n - 1) {
        return 1;
    }
    if (i >= m || j >= n) {
        return 0;
    } else
        return countPaths(i + 1, j, m, n) + countPaths(i, j + 1, m, n);
}
    
 public static int uniquePaths(int m, int n) {
    int x = m + n - 2;
        int r = Math.min(m, n) - 1;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res *  (x - r + i) / i;

        }
        return (int) res;

           
    }

}
