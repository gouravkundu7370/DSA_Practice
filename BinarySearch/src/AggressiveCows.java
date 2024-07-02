import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {

        int[] stalls = { 0, 3, 7, 4, 9, 10 };
        System.out.println(aggresiveCows(stalls, 4));
    }

    public static int aggresiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int cntCows = 1;
        int last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }

        }
        if (cntCows >= cows) {
            return true;

        }
        return false;
    }
}
