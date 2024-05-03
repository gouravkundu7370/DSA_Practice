public class TappingRainwater {
    public static void main(String[] args) {

        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }
     public static int trap(int[] height) {
         int n = height.length;
         int left = 0, right = n - 1;
         int res = 0;
         int left_max = 0, right_max = 0;
         while (left <= right) {
             if (height[left] <= height[right]) {
                 if (height[left] >= left_max) {
                     left_max = height[left];
                 } else {
                     res += left_max - height[left];
                 }
                 left++;
             } else {
                 if (height[right] >= right_max) {
                     right_max = height[right];
                 } else {
                     res += right_max - height[right];
                 }
                 right--;
             }
         }

         return res;
    }
}
