

public class AllocateBooks {
    public static void main(String[] args) { 

        int[] arr = { 73, 58, 30, 72, 44, 78, 23, 9  };
        System.out.println(books(arr, 5));
    }

    public static int books(int[] A, int B) {

         if(B>A.length)
        {
            return -1;
        }
        int sum = 0;
        sum = sum + A[0];
        int max = A[0];
        int ans = -1;
        for(int i=1;i<A.length;i++)
        {
            sum +=A[i];
            if(A[i]>max)
            {
                max = A[i];
            }
        }
        int start = max;
        int end = sum;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            int count = 1; // student count;
            int pages = 0;
            for(int i=0;i<A.length;i++)
            {
                pages +=A[i];
                if(pages>mid)
                {
                    count++;
                    pages = A[i];
                }
            }
            if(count<=B)
            {
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    
}
