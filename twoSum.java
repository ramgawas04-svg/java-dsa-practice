import java.util.Arrays;
import java.util.HashMap;
public class twoSum {
    public static void main(String[] args) {
        int [] nums = {3,3};
        int target  = 6;

        System.out.println("Indices: " + Arrays.toString(twoSum(nums,target)));
    }

    private static int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(hm.containsKey(target - nums[i])){
                return new int[] {i, hm.get(target - nums[i])};
            }
            hm.put(nums[i], i);
        }
        return new int[0];

    }
}
