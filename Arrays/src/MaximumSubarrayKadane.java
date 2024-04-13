import java.util.Arrays;

public class MaximumSubarrayKadane {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    
        System.out.println(maxSubArray(nums));
      int [] ans =   maxSubArray1(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0)
                sum = 0;
        }

        return max;
    }
     public static int[] maxSubArray1(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;
        int s = -1;
        int e = -1;
      
        
        for (int i = 0; i < n; i++) {
            
            if (sum == 0) {
                s = i;
            }
            sum += nums[i];
            
            if (sum > max) {
            
                e = i;
                max = sum;
           }
          
            if (sum < 0) {
                sum = 0;

            }

        }
        int[] arr = new int[e - s+1];
        for (int i = 0; i <= e - s; i++) {
            arr[i] = nums[i+s ];
        }
        return arr;

       
    }
}

