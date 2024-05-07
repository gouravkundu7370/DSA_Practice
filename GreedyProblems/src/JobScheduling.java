
import java.util.Arrays;


public class JobScheduling {
    static class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

public static void main(String[] args) {

    Job[] jb = { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30) };
    int[] ans = JobScheduling1(jb, jb.length);

    System.out.println(Arrays.toString(ans));
    

    

    }
     public static  int[] JobScheduling1(Job arr[], int n)
     {
         Arrays.sort(arr, (a, b) -> b.profit - a.profit);
         int max = 0;
    
         for (int i = 0; i < n; i++) {
             max = Math.max(max, arr[i].deadline);
         }
    int[] vis = new int[max+1];
    for (int i = 0; i < max+1; i++) {
        vis[i] = -1;
    }
    
    int size = 0;
    int sum = 0;
    
    for(int i=0; i<n; i++) {
        for(int j=arr[i].deadline; j>0; j--) {
            if(vis[j] == -1) {
                vis[j] = i;
                size++;
                sum += arr[i].profit;
                break;
            }
        }
    }
    
    int[] ans =  {size, sum};
    return ans;
    }
     
        
}


 


