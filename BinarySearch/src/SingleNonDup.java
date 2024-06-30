public class SingleNonDup {
    public static void main(String[] args) {

        int[] nums = { 1, 1, 2,2, 3, 3, 4, 4, 8 };
        System.out.println(singleNonDuplicate(nums));
    }
    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            // check left side only
           
            // check only for left side
            // 1st instance -> even index
            //2nd instance -> odd index
            // && vicerversa for right side
             if ( nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}
