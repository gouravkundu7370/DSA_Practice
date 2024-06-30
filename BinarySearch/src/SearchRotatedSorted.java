public class SearchRotatedSorted {
    public static void main(String[] args) {

        int[] nums = {1,3};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // left side is sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // right side sorted
            else {
                if (target >= nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
    
        return -1;
    }
    
}
