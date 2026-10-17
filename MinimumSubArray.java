
public class MinimumSubArray {
    public static void main(String [] args){
        int [] nums1 = {2,3,1,2,4,3};
        int target1 = 7;

        int [] nums2 = {1,4,4};
        int target2 = 4;

        System.out.println(minSubArrayLen(target1, nums1));
        System.out.println(minSubArrayLen(target2, nums2));
    }
    private static int minSubArrayLen(int target, int[] nums){

        int left = 0;
        int sum = 0;
        int minLength = nums.length;
        for(int right = 0;right < nums.length;right++){

            sum += nums[right];

            while(sum >= target){
                minLength = Math.min(minLength, right-left+1);
                sum -=nums[left];
                left++;
            }
            
        }

        return minLength;
    }
}
