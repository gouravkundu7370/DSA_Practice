import java.util.HashMap;


public class LargestSubArrayKSum {
    public static void main(String[] args) {

        int A[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLen(A, A.length));
        
        int a[] = { 2, 3, 5, 1, 9 };
        System.out.println(getLongestSubarray1(a, 10));
    }
     static int maxLen(int arr[], int n)
     {
         // Your code here
         return getLongestSubarray(arr, 0);

     }

     public static int getLongestSubarray(int[] a, int k) {
         int sum = 0;
         int maxLen = 0;
         HashMap<Integer, Integer> set = new HashMap<>();
         for (int i = 0; i < a.length; i++) {
             sum += a[i];
             if (sum == k) {
                 maxLen = Math.max(maxLen, i + 1);
             }
             int diff = sum - k;
             if (set.containsKey(diff)) {
                 int len = i - set.get(diff);
                 maxLen = Math.max(maxLen, len);
             }
             if (!set.containsKey(sum)) {
                 set.put(sum, i);

             }
         }
         return maxLen;
     }
     // if the array does contains all integers > 0 
    public static int getLongestSubarray1(int[] a, int  k) {
        int left = 0;
        int right = 0;
        int sum = a[0];
        int maxLen = 0;
        int n = a.length;
        while (left <= right && right < n) {
            while (sum > k) {
                sum -= a[left];
                left++;

            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
            if (right < n) {
                sum += a[right];
            }

        }
        return maxLen;
    }
}
