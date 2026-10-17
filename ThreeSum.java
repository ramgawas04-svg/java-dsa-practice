
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class ThreeSum {
        public static void main(String [] args){

            int [] nums = {-1,0,1,2,-1,-4};
            System.out.println(ThreeSum(nums));
        }
//ThreeSum
/*  
first Create Arraylist
then Sort the array using Arrays.sort()
go for for loop with i;
if i is duplicate then move forward with continue;
now two pointers approach(similar to container with most water )
will use while loop (left<right)
int sum = i +left +right (arrays values)
if(sum ==0) then add into result ArrayList and left++ right-- check for duplicate and skip further
else if(sum< 0) then left++
else right--;
return result
 */
        private static List<List<Integer>> ThreeSum(int [] nums){
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);
            for(int i = 0;i<nums.length-2;i++){

                int left = i+1;
                int right = nums.length-1;

                while(left < right){

                    int sum = nums[i] + nums[left] + nums[right];
                    
                    if(sum == 0){

                        result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;

                        while(left < right && nums[left]== nums[left-1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right+1]){
                            right--;
                        }
                    }
                    else if(sum < 0){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
            return result;
        }
}
