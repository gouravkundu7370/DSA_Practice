import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
       
        int[] nums = { 2,1,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        

    }

    public static void nextPermutation(int[] nums) {
        int length = nums.length;
       
        int peak = -1;//edge case : if its the last one i.e. the highest number
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                peak = i;
                break;
            }

        }
        if (peak != -1) {
            for (int i = length - 1; i >= peak; i--) {
                if (nums[i] > nums[peak]) {
                    int temp = nums[i];
                    nums[i] = nums[peak];
                    nums[peak] = temp;
                   
                    break;
                }
            }
            if (peak != length-2) {
                reverse(peak+1, length-1, nums);
            }
        
        }
        else {
            reverse(0, length-1, nums);
        }
    }

    public static void reverse(int i, int j, int[] nums) {
        while (i < j) {
            int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            
        }
    }
}
