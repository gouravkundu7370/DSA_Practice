import java.util.Arrays;
import java.util.Stack;

public class NextGreter1 {
    public static void main(String[] args) {

        int[] arr = {4,12,5,3,1,2,5,3,1,2,4,6  };
        System.out.println(Arrays.toString(nextGreater(arr)));
    }

    public static int[] nextGreater(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && arr[i] >= stk.peek()) {
                stk.pop();
            }
            if (!stk.empty()) {
                res[i] = stk.peek();
            } else {
                res[i] = -1;
            }
            stk.push(arr[i]);
        }
        return res;
    }
}
