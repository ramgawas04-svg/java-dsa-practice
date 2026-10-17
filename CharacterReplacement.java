import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class CharacterReplacement {
    public static void main(String [] args){
        String s = "AABABABA";
        int k = 2;
        System.out.println(characterReplacement(s, k));
        String str1 = "abc";
        String str2 = "ramgawas";
        System.out.println(checkInclusion(str1, str2));
        System.out.println(reverseString(str2));
    }
    //String s = "AABA";
    //int k = 1;
    private static int characterReplacement(String s , int k){

        int left = 0 ;
        int maxLength = 0;
        int maxFrequency = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int right =0;right< s.length();right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFrequency = Math.max(maxFrequency,map.get(ch));
            // int windowSize = right-left+1;
           while(right-left+1 - maxFrequency > k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
           }
           maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    private static boolean checkInclusion(String s1, String s2){

        int left = 0 ;
        int [] s1Freq = new int[26];
        int [] windowFreq = new int[26];

        for(char ch : s1.toCharArray()){
            s1Freq[ch - 'a']++;
        }
        for(int right = 0;right<s2.length();right++){

            windowFreq[s2.charAt(right) - 'a']++;
            if(right-left+1 == s1.length()){

                if(Arrays.equals(s1Freq,windowFreq)){
                    return true;
                }
                windowFreq[s2.charAt(left) - 'a']--;
                left++;

            }
        }
        return false;
    }

     
}


class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minSubArrayLen = 0;
        int sum = 0;
        for( int right = 0; right < nums.length;right++){
            
            while(sum >= target){
                minSubArrayLen = Math.max(minSubArrayLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            sum +=nums[right];
        }
        return minSubArrayLen;
    }
}