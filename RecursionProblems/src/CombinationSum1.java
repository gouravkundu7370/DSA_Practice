import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {
    
    public static void main(String[] args) {

        int[] arr = { 2, 3, 6, 7 };
        System.out.println( combinationSum(arr, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        findComb(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public static void findComb(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[index] <= target) {
            ds.add(arr[index]);
            findComb(index, arr, target - arr[index], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findComb(index+1, arr, target, ans, ds);
    }
    
}
