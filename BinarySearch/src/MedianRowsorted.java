public class MedianRowsorted {
    public static void main(String[] args) {

        int[][] M = {{1, 3, 5}, 
             {2, 6, 9}, 
                { 3, 6, 9 } };

                System.out.println(median(M, 3, 3));

    }

    public static int median(int matrix[][], int R, int C) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(matrix[i][C - 1], high);
        }
        int req = (R * C) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(matrix, R, C, mid);
            if (smallEqual <= req) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countSmallEqual(int[][] matrix, int n, int m, int x) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += upper(matrix[i], x, m);
        }
        return count;
    }

    public static int upper(int[] matrix, int x, int n) {
        int ans = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
