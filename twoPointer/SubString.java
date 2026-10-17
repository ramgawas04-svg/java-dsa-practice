package twoPointer;
import java.util.HashSet;
import java.util.Set;
public class SubString {
    
    public static Set<String> getAllUnqiueSubstring(String input){

            Set<String> uniqueSubstrings = new HashSet<>();

                for(int i=0;i<input.length();i++){
                    for(int j =i+1;j<=input.length();j++){

                        uniqueSubstrings.add(input.substring(i,j));
                    }
                }

            return uniqueSubstrings;
    }

    public static int lengthOfLongesUniqueSubstring(String input){

        Set<Character> seenCharacter = new HashSet<>();

        int left = 0 ;
        int maxlength = 0;

        for(int right = 0;right< input.length();right++){

            while(seenCharacter.contains(input.charAt(right))){
                seenCharacter.remove(input.charAt(left));
                left++;
            }

            //add new character
            seenCharacter.add(input.charAt(right));
            maxlength = Math.max(maxlength, right-left+1);
        }

        return maxlength;
    }

    public static void main(String [] args){
        String input = "abcdacb";

        Set<String> uStrings = getAllUnqiueSubstring(input);

        System.out.println("Size of the unique substring = "+ uStrings.size() );
        System.out.println("All the unique substrings = " + uStrings);

        System.out.println("Length of longest unique substring is : "+ lengthOfLongesUniqueSubstring(input));
     }
}
