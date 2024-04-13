import java.util.Arrays;

public class SortColors {
    // sort according to 0,1,2
    public static void main(String[] args) {

        int[] ans = { 2, 0, 2, 1, 1, 0 };
        sortColors(ans);
        System.out.println(Arrays.toString(ans));
    }
     public static void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
