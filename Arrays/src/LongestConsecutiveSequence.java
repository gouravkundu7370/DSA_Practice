import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] a = { 100, 200, 1, 2, 3, 4 };

        System.out.println(longestConsecutive(a));
         System.out.println(longestConsecutive1(a));
    }

    public static int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int prevSmaller = Integer.MIN_VALUE;
        int currcnt = 0;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == prevSmaller) {
                currcnt += 1;
                prevSmaller = nums[i];
            } else if (nums[i] != prevSmaller) {
                currcnt = 1;
                prevSmaller = nums[i];
            }
            longest = Math.max(longest, currcnt);
        }

        return longest;
    }

    public static int longestConsecutive1(int[] nums) {
         int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int longest = 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (Integer integer : set) {
            if (!set.contains(integer - 1)) {
                int count = 1;
                int x = integer;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    count += 1;

                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}
