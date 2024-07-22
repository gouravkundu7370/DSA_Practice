import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {

        int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
        int[] ans = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
       
   
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> store = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            store.put(nums1[i], i);
        }

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            if (store.containsKey(nums2[i])) {
                if (stack.isEmpty()) {
                    result[store.get(nums2[i])] = -1;
                } else {
                    result[store.get(nums2[i])] = stack.peek();
                }
            }
            stack.push(nums2[i]);
        }
        return result;

    }
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        /*Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Traverse nums2 to find next greater element for each element
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        // Result array to store answers for nums1
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1); // Initialize with -1
        
        // Query nums1 against the nextGreaterMap
        for (int i = 0; i < nums1.length; i++) {
            if (nextGreaterMap.containsKey(nums1[i])) {
                result[i] = nextGreaterMap.get(nums1[i]);
            }
        }
        
        return result;*/
        int[] index = new int[10000];
        for (int i = 0; i < nums2.length; i++)
            index[nums2[i]] = i;
        
        for (int i = 0; i < nums1.length; i++)
            nums1[i] = findNextGreater(index[nums1[i]], nums2);

        return nums1;
    }

    private int findNextGreater(int index, int[] nums2) {
        for (int i = index + 1; i < nums2.length; i++) {
            if (nums2[i] > nums2[index])
                return nums2[i];
        }
        return -1;
    }
}

