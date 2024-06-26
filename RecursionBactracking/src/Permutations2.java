import java.util.ArrayList;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3 };
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermute(nums, 0, ans);
        return ans;
    }

    public static void findPermute(int[] nums, int index,List < List < Integer >> ans) {
        if (index == nums.length) {
            // copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            findPermute(nums, index + 1, ans);
            swap(i, index, nums);
        }



    }
     public static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
