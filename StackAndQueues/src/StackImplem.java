import java.util.ArrayList;

public class StackImplem {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        MyStack stack = new MyStack();
        int[][] inp = {{1,2},
                { 1, 3 }, { 2 }, { 1, 4 }, { 2 } };
        for (int[] is : inp) {
            if (is[0] == 1) {
                stack.push(is[1]);
            }
            if (is[0] == 2) {
                int ans = stack.pop();
                list.add(ans);
            }
        }
        System.out.println(list);

    }

   static class MyStack {
        private int[] arr;
        private int top;


        public MyStack() {
            arr = new int[1000];
            top = -1;
        }

        public void push(int x) {
            // Your Code
            if (top == arr.length) {
                return;
            }
            arr[++top] = x;

        }

        public int pop() {
            // Your Code
            if (top == -1) {
                return Integer.MIN_VALUE;
            }
            if (top == 0) {
                return arr[top--];

            }

            return arr[top--];

        }
        

    }
}
