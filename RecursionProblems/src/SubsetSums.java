import java.util.ArrayList;

public class SubsetSums {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);

        ArrayList<Integer> ans = subsetSums(arr, arr.size());
        System.out.println(ans);
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> sumSubset = new ArrayList<>();
        helper(0, 0, arr, n, sumSubset);
        return sumSubset;
    }

    static void helper(int index, int sum, ArrayList<Integer> arr, int n, ArrayList<Integer> sumSet) {
        if (index == n) {
            sumSet.add(sum);
            return;

        }
        //pick element (left side)
        helper(index + 1, sum + arr.get(index), arr, n, sumSet);
        //not pick element (right side)
        helper(index+1, sum, arr, n, sumSet);
    }
}
