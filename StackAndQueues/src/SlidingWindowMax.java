import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindowMax {
    public static void main(String[] args) {

        int[] nums = { 1, 3, -1, -3, 5, 3, 2, 1, 6 };
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
     public static int[] maxSlidingWindow(int[] nums, int k) {
         List<Integer> res = new ArrayList<>();
         Deque<Integer> deque = new LinkedList<>();
         for (int i = 0; i < nums.length; i++) {
             int num = nums[i];
             while (!deque.isEmpty() && deque.getLast() < num) {
                 deque.pollLast();
             }
             deque.addLast(num);
             if (i >= k && nums[i - k] == deque.getFirst()) {
                 deque.pollFirst();
             }
             if (i >= k - 1) {
                 res.add(deque.getFirst());
             }
         }
      return res.stream().mapToInt(i -> i).toArray();    
    }
}

