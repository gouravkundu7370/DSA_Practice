import java.util.Arrays;
import java.util.TreeMap;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = { 3,2,4};

        System.out.println(Arrays.toString(twoSum(nums, 6)));
         System.out.println(Arrays.toString(twoSum1(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = { -1, 1 };
        // HashMap<Integer,Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (!map.containsKey(diff)) {
                map.put(nums[i], i);
            } else if (map.containsKey(diff)) {
                ans[0] = map.get(diff);
                ans[1] = i;
            }

        }
        return ans;
    }
    public static int[] twoSum1(int[] nums, int target) {
        int[] ans = {-1,1};
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while (i< j) {
            int diff = nums[i] + nums[j];
            if (diff == target) {
                ans[0] = i;
                ans[1] = j;
                break;
            }
            else if (diff < target) {
                i++;
            }
            else if (diff > target) {
                j--;
            } 
            
        }
        return ans;
    }
}
