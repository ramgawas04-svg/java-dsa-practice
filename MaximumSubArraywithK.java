public class MaximumSubArraywithK {
    
    public static void main(String [] args){
        int [] arr = { 1,2,3,6,5,4,3,4};
        System.out.println(maximumSumSubarray(arr, 3));
    }
    private static int maximumSumSubarray(int[] nums, int k){
        
        int left = 0;
        int maxSum = 0;
        int windowsum  = 0;

            for(int right = 0;right< nums.length;right++){

                // int sum = nums[left] + nums[left+1] + nums[right];
                windowsum+= nums[right];
                if(right - left + 1==k){
                    maxSum = Math.max(maxSum, windowsum);
                    windowsum -= nums[left];
                    left++;
                }
                
            }
        return maxSum;
    }
}
