
import java.util.Arrays;

public class TwoPointers {
    
    public static void main(String [] args){

        // int [] nums1 = {1,2,3,0,0,0};
        // int m =3;
        // int [] nums2 = {2,5,6};
        // int n = 3;
        // mergeSortedArray(nums1, m, nums2, n);

        // int [] nums = {0,0,1,1,2,3,4,4};
        // // removeDuplicates(nums);

        // System.out.println(removeDuplicate(nums));

        // int [] numszeros = {0,1,0,2,0,3,0,4,0,6};
        // moveZeroes(numszeros);
        int [] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

    }

    private static void mergeSortedArray(int [] nums1, int m, int [] nums2, int n){

        int i = m - 1;
        int j = n - 1;
        int k = m+n-1;

        while(i>=0 && j>=0){

            if(nums1[i] < nums2[j]){
                nums1[k]= nums2[j];
                j--;
                k--;
            }else{
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }
        while(j>=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
        System.out.println(Arrays.toString(nums1));
    }
 // 0,0,1,2,2,3
    private static void removeDuplicates(int[] nums){

        int i = 0;
        int n = nums.length;
        int k =0;
        while(i< n){
            int current = nums[i];

            while(i< nums.length && nums[i]==current){
                i++;
            }
        nums[k]= current;
        k++;
        }
        while(k< n){ 
            nums[k] = 0;
            k++;
        }

       System.out.println(Arrays.toString(nums));
    }

    private static int removeDuplicate(int [] nums){

        int slow = 0;
        int fast = 0;
        
        while(fast < nums.length){
            if(nums[slow]!= nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        System.out.println(Arrays.toString(nums));
        return slow + 1;
    }
    private static void moveZeroes(int [] nums){
        int slow = 0;

        for(int i= 0;i<nums.length;i++){
            if(nums[i]!=0){
            nums[slow] = nums[i];
            slow++;
            }
        }
        while(slow < nums.length){
            
            nums[slow]=0;
            slow++;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static int maxArea(int [] height){

        int maxArea = 0;
        // for(int i=0;i<height.length;i++){
        //     for(int j=i+1;j<height.length;j++){
        //         int area = Math.min(height[i],height[j]) * (j-i);
        //         if(area > maxArea){
        //             maxArea = area;
        //         }
        //     }
        // }
        int left = 0;
        int right = height.length-1;

        while(left < right){
            int area = Math.min(height[left],height[right]) * (right - left);
            if(maxArea < area){
                maxArea = area;
            }
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}

