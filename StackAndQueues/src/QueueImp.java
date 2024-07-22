import java.util.ArrayList;

public class QueueImp {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        MyQueue queue = new MyQueue();
        int[][] inp = {{1,2},
                { 1, 3 }, { 2 }, { 1, 4 }, { 2 } };
        for (int[] is : inp) {
            if (is[0] == 1) {
                queue.push(is[1]);
            }
            if (is[0] == 2) {
                int ans = queue.pop();
                list.add(ans);
            }
        }
        System.out.println(list);
    }

    static class MyQueue {

        int front, rear;
        int arr[] = new int[100005];

        MyQueue() {
            front = 0;
            rear = 0;
        }

        //Function to push an element x in a queue.
        void push(int x) {
            // Your code here
            if (rear == arr.length) {
                return;
            }
            arr[rear++] = x;
        }

        //Function to pop an element from queue and return that element.
        int pop() {
            // Your code here
            if (rear == front) {
                front = 0;
                rear = 0;
                return -1;

            }
            return arr[front++];
        }
    }
}
