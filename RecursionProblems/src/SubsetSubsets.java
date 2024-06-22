import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSubsets {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

      Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        sub(0,nums,new ArrayList<>(),ans);
        return ans;
    }

   static void sub(int ind,int[] nums,List<Integer>ds,List<List<Integer>>ans){
        ans.add(new ArrayList<>(ds));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]) continue;
            ds.add(nums[i]);
            sub(i+1,nums,ds,ans);
            ds.remove(ds.size()-1);
        }
    }
}
