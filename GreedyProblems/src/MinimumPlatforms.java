import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
int arr[] = {900, 940, 950, 1100, 1500, 1800};
int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
System.out.println(findPlatform(arr, dep, arr.length));
    }
     static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int max = 1;
        int platform = 1;
        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platform++;
                i++;
            }
            else if (arr[i] > dep[j]) {
                platform--;
                j++;

            }
            if (platform > max) {
                max = platform; 
            }
            
        }
        return max;
    }
}
