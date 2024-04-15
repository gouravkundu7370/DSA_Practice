import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 },{16,17} };
        int[][] ans = merge(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals based on their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Initialize an empty list to store the merged intervals
        List<int[]> merged = new ArrayList<>();
        
        // Step 3: Iterate through the sorted intervals
        for (int[] interval : intervals) {
            // Step 4: Check if the current interval overlaps with the last merged interval
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                // If it doesn't overlap, add it to the merged list
                merged.add(interval);
            } else {
                // If it overlaps, merge it with the last merged interval
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        
        // Step 5: Convert the list of merged intervals to a 2D array and return
        return merged.toArray(new int[merged.size()][]);
    }

     public static int[][] merge1(int[][] intervals) {
      int min=Integer.MAX_VALUE;
      int max=Integer.MIN_VALUE;
      for(int i=0; i<intervals.length; i++){
        min=Math.min(min,intervals[i][0]);
        max=Math.max(max,intervals[i][0]);
      }  
      int[] range=new int[max-min+1];
      for(int i=0; i<intervals.length; i++){
        range[intervals[i][0]-min]=Math.max(intervals[i][1]-min,range[intervals[i][0]-min]);
      }
      int start=0, end=0;
      LinkedList<int[]>result=new LinkedList<>();
      for(int i=0; i<range.length; i++){
        if(range[i]==0){
            continue;
        }if(i<=end){
            end=Math.max(range[i], end);
        } else{
            result.add(new int[]{start+min, end+min});
            start=i;
            end=range[i];
        }
      }
      result.add(new int[]{start+min, end+min});
      return result.toArray(new int[result.size()][]);
    }
}
