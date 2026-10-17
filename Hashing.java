
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

public class Hashing {
    public static void main(String [] args){

        int [] arr = {0,1,3,4,5,6,7,2};

        System.out.println("does array contain duplicate values -->"+ containsDuplicate(arr));

        System.out.println("Missing number is - "+ missingNumber(arr));

        twoSum(arr, 7);

        int [] result = twoSumUsingHashMap(arr,7);
        for(int i:result){
        System.out.println(i);
        }

        String str1 = "eatq";
        String str2 = "tea";

        System.out.println("Given string are anagram or not -->"+ isAnagram(str1, str2));

        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagram(strs));
    }

    private static boolean containsDuplicate(int [] arr){

        Set<Integer> hm = new HashSet<>();

        for(int i=0;i<arr.length;i++){

            if(hm.contains(arr[i])){
                return true;
            }
            hm.add(arr[i]);
        }

        return false;
    }

    private static int missingNumber(int [] arr){

        Set<Integer> set= new HashSet<>();

        for(int i:arr){
            set.add(i);
        }
        
        for(int i = 0;i<= arr.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;

    }

    private static void twoSum(int [] arr, int twosum){

        for(int i =0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==twosum){
                    System.out.println("["+ arr[i] + " , " + arr[j]+ " ]");
                }
            }
        }
    }

    private static int [] twoSumUsingHashMap(int [] arr, int target){

        Map<Integer, Integer> hm = new HashMap<>();

        for(int i =0;i<arr.length;i++){
            int need = target - arr[i];

                if(hm.containsKey(need)){
                    return new int [] {hm.get(need), i};
                }

                hm.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }

    private static boolean isAnagram(String s1, String s2){

        if(s1.length() != s2.length()){
            return false;
        }
        Map< Character, Integer> hm = new HashMap<>();

        for(char ch : s1.toCharArray()){
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }

        for(char ch : s2.toCharArray()){

            if(!hm.containsKey(ch)){  // to check if character is there or not
                return false;
            }

            hm.put(ch,hm.getOrDefault(ch, 0)-1);  //reduce the count by 1

            if(hm.get(ch) < 0){  //should not go below 0
                return false;
            }
        }

        return true;
    }

    private static List<List<String>> groupAnagram(String [] arr){

            Map<String, List<String>> map = new HashMap<>();

            for(String word: arr){

                char [] ch = word.toCharArray();
                Arrays.sort(ch);

                String key = new String(ch);
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(word);
            }


        return new ArrayList<>(map.values());
    }
}

