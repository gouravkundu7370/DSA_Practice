import java.util.HashMap;

public class SubarraysXorK {
    public static void main(String[] args) {
        
int[] a = {4, 2, 2, 6, 4};
int k = 6;
          System.out.println("The number of subarrays with XOR k is: " + solve(a, k));
    }

    public static int solve(int[] A, int B) {
        
        int n = A.length;
        int xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(xor, 1);
        int count = 0;

        for (int i = 0; i < n; i++) {
            //prefix xor
            xor ^= A[i];
            // x = xor^ k
            int x = xor ^ B;

            if (map.containsKey(x)) {
                count += map.get(x);

            }
            if (map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }
        }

        return count;
    }
}
