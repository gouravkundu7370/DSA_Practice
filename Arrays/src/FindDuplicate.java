public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2 };
        // System.out.println(findDuplicate(nums));
        // System.out.println(findDuplicate1(nums));
        System.out.println(findDuplicate2(nums));
    }
    public static int findDuplicate(int[] nums) {
         int ans = 0;
        int i = 0;
        while (i < nums.length){
            int correctIndex = nums[i] -1;
            if (nums[i] != nums[correctIndex]){
                swap(nums,i,correctIndex);
            }
            else{
                i++;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index+1){
                ans = nums[index];
            }
        }
        return ans;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int findDuplicate1(int[] nums) {
        int a[] = new int[nums.length + 1];
        for (int num : nums) {
            if (a[num] != 0) {
                return num;
            }
            a[num] = num;
        }
        return 0;
    }
     public static int findDuplicate2(int[] nums) {
         int f = 0, s = 0;
         do {
             s = nums[s];
             f = nums[nums[f]];
         } while (f != s);
         s = 0;
         while (f != s) {
             s = nums[s];
             f = nums[f];
            
         }
         return s;

    }
    
}
