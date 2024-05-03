public class MaxConsecOne {
    
    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 0, 1 };
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount=0;
        int curCount=0;

        // Iterate through each element in the array
        for(int element: nums){
            if(element==0){
        //reset curCount and maxCount whenever 0 is encountered.
                if(maxCount<curCount){
                    maxCount=curCount;
                }
                curCount=0;                
            }
            else{
                curCount++;
            }
        }
        return maxCount>curCount? maxCount:curCount;
        
    }
}
