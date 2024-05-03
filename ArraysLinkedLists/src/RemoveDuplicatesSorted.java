import java.util.Arrays;

public class RemoveDuplicatesSorted {
    public static void main(String[] args) {

        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int ans = removeDuplicates(nums);
        System.out.println(ans);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;
      
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                
                nums[k] = nums[i];
               
                k++;
            }

        }
        return k; 
    }
}
