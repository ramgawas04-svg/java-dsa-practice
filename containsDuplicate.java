import java.util.HashMap;
import java.util.HashSet;
public class containsDuplicate {
    public static void main(String [] args){

        int [] nums1 = {1,2,3,1};
        boolean containsDuplicate = containsDuplicate(nums1);
        System.out.print(containsDuplicate);
    }

    private static boolean containsDuplicate(int[] nums) {
        
        // HashMap <Integer,Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums){
            // hm.put(num, hm.getOrDefault(num,0)+1);
            if(hs.contains(num)){
                return true;
            }
            hs.add(num);
        }
        return false;
    }

}
