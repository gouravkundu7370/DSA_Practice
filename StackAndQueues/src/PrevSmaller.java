import java.util.Arrays;
import java.util.Stack;

public class PrevSmaller {
    public static void main(String[] args) {

        int[] A = { 4, 5, 2, 10, 8 };
        System.out.println(Arrays.toString(prevSmaller(A)));

    }

    public static int[] prevSmaller(int[] A) {
        int[] res = new int[A.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {

            while (!stack.isEmpty() && stack.peek() >= A[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            } else {
                res[i] = -1;
            }
            stack.push(A[i]);
        }
        return res;
    }
}
