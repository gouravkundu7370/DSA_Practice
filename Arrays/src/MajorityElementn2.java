public class MajorityElementn2 {
    public static void main(String[] args) {

        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(arr));

    }

    public static int majorityElement(int[] nums) {
        
        int el = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                el = nums[i];
            } else if (nums[i] == el) {
                count++;
            } else {
                count--;
            }
        }
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el) {
                count1++;
            }
            if (count1 > nums.length /2) {
                return el;
            }
        }
        return -1;
    }
}
