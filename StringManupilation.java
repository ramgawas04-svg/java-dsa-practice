
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class StringManupilation {
     
    public static void main(String [] args){

        String s = "aaaabbcddeeefff";

        String rev = reverseString(s);
        System.out.println(rev);

        boolean isPalindrome = isPalindrome(s);

        System.out.println(isPalindrome);

        Map<Character,Integer> hm = countCharacterFrequency(s);

        System.out.println(hm);

        String [] arr = {"flower", "flow", "right"};

        System.out.println(logestCommonPrefix(arr));

        System.out.println(stringCompression(s));

        String s1 = "ababsdafabac";
        String s2 = "mraasdf";
        System.out.println("Two strings are Anagram -"+isAnagram(s1, s2));

        System.out.println("Longest non repeating string "+ lengthofLongestSubstringWithoutRepeatingCharacter(s1));

        System.out.println("LongestSubstring--"+longestSubStringWithoutRepatingCharacter(s1));
    }

    private static String  reverseString(String input){

        char [] arr = input.toCharArray();

        int left = 0;
        int right = arr.length-1;

        while(left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        return String.valueOf(arr);
    }

    private static boolean isPalindrome(String input){

        char[] arr = input.toCharArray();

        int left = 0;
        int right = arr.length-1;

        while(left < right){

            if(arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private static Map<Character, Integer> countCharacterFrequency(String input){

            Map<Character, Integer> hm = new HashMap<>();
            input = input.toLowerCase();
            for(int i =0;i<input.length();i++){

                char ch = input.charAt(i);

                if(ch == ' '){
                    continue;
                }
                hm.put(ch, hm.getOrDefault(ch,0)+1);
            }

        return hm;
    }

    private static String logestCommonPrefix(String [] input){

        if(input==null || input.length==0){
            return "";
        }

        String prefix = input[0];

        for(int i=1;i<input.length;i++){

            while(!input[i].startsWith(prefix)){

                prefix = prefix.substring(0,prefix.length()-1);

                if(prefix.isEmpty()){
                    return "";
                }
                System.out.println(prefix);
            }
        }

        return prefix;
    }

    private static String stringCompression(String input){

        String compressedString = "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = input.length();
        while(i<n){
            char current = input.charAt(i);
            int count = 0;

            while(i<n && input.charAt(i)==current){
                i++;
                count++;
            }

            sb.append(current);
            // compressedString = compressedString + current;
            if(count > 1){
                // compressedString = compressedString + count;
                sb.append(count);
            }
        }

        // return compressedString;
        return sb.toString();
    }

    private static boolean isAnagram(String str1, String str2){

        Map<Character, Integer> hm = new HashMap<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for(int i=0;i<str1.length();i++){
            char ch = str1.charAt(i);

            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        for(char ch: str2.toCharArray()){

            if(!hm.containsKey(ch)){
                return false;
            }
            hm.put(ch,hm.get(ch)-1);

            if(hm.get(ch) < 0){
                return false;
            }
        }
        return true;
    }

    private static int lengthofLongestSubstringWithoutRepeatingCharacter(String input){

        int left = 0 ;
        int maxLength = 0;
            Set<Character> set = new HashSet();
        int i =0;
        int start = 0 ;
        while(i< input.length()){

                if(!set.contains(input.charAt(i))){
                    set.add(input.charAt(i));
                    maxLength = Math.max(maxLength, i - left +1);
                    start = left;
                    i++;
                } else {
                    set.remove(input.charAt(left));
                    left++;
                }

        }

        return maxLength;
    }

    private static String longestSubStringWithoutRepatingCharacter(String input){

        Set<Character> set = new HashSet();
        int slow = 0;
        int maxLength = 0;
        int start = 0;
        for(int fast = 0;fast<input.length();fast++){

            char ch = input.charAt(fast);

            while(set.contains(ch)){
                set.remove(input.charAt(slow));
                slow++;
            }

            set.add(ch);
            if(fast-slow +1 > maxLength){
                maxLength = fast-slow +1;
                start = slow;
            }
        }
        return input.substring(start, start+ maxLength);
    }
}
