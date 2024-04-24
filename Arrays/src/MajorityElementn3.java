import java.util.ArrayList;
import java.util.List;

public class MajorityElementn3 {
    public static void main(String[] args) {

        int[] nums1 = { 3, 2, 3 };
        System.out.println(majorityElement(nums1));

        int[] nums2 = { 1, 2 };
        System.out.println(majorityElement(nums2));

        int[] nums3 = { 1 };
        System.out.println(majorityElement(nums3));

        int[] nums4 = { 2,2,1,3 };
        System.out.println(majorityElement(nums4));
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != ele2) {
                count1 = 1;
                ele1 = nums[i];

            } else if (count2 == 0 && nums[i] != ele1) {
                count2 = 1;
                ele2 = nums[i];

            } else if (ele1 == nums[i]) {
                count1++;
            } else if (ele2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            }
        }
       
        if (count1 > nums.length / 3) {
             ans.add(ele1);
        }
        if (count2 > nums.length / 3) {
             ans.add(ele2);
        }
        

        return ans;
    }
}
