import java.util.Arrays;
import java.util.HashSet;

public class LongestSequence {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 101, 1, 2, 2, 3 };
        int LongestSequence = longestConsecutiveSequence(nums);
        System.out.println(LongestSequence);

        int longest = longestSequence(nums);
        System.out.println(longest);
    }

    private static int longestConsecutiveSequence(int[] nums) {

        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        int longestSequence = 0;
        
        for(int num : hs){
            if(num!=Integer.MIN_VALUE && hs.contains(num-1)){
                continue;
            }
            int current = num;
            int length = 1;

            while(current!= Integer.MAX_VALUE && hs.contains(current+1)){

                current++;
                length++;
            }
            longestSequence = Math.max(longestSequence, length);
        }
        return longestSequence;
    }

    private static int longestSequence(int [] nums){

        Arrays.sort(nums);
         int longestSequence = 1;
         int length = 1;
        for(int i =1; i< nums.length;i++){
            
            if(nums[i]==nums[i-1]){
                continue;
            }
            else if(nums[i]==nums[i-1]+1){
                length++;
            }
            else{
                length = 1;
            }

            longestSequence = Math.max(longestSequence, length);
        }
        return longestSequence;
    }
}
