import java.util.Arrays;
public class SortColors {
    
    public static void main(String [] args){

        int [] nums = { 1,0,2,1,2,0};
        sortColors(nums);
    }

    private static void sortColors(int [] nums){

        for(int i=0;i< nums.length;i++){

            int left =0;
            int right = nums.length-1;
            int mid = i+1;
            System.out.println(Arrays.toString(nums));
            if(nums[left]==0){
                nums[left] = 0;
                left++;
                mid++;
            }
            else if (nums[mid] == 1){
                nums[mid]=1;
                mid++;
            }
            else{
                nums[right] = 2;
                right--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
