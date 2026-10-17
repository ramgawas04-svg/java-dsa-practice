
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedHashMap;


public class DuplicateCharacterinString {
    
    private static void countCharcterinString(String input){

        Map<Character, Integer> hm = new HashMap<>();

        for(int i =0;i<input.length();i++){
            input = input.toLowerCase();
            char ch = input.charAt(i);

            if(ch == ' '){
                continue;
            }

            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry : hm.entrySet()){
            if(entry.getValue() > 1){
            System.out.println(entry.getKey()+" --> "+ entry.getValue());
            }
        }
    }

    private static Map<Character, Integer> getcountCharcterinString(String input){

        Map<Character,Integer> hm = new HashMap<>();
//n+1
        input = input.toLowerCase();

        for(int i= 0;i< input.length();i++){

            char ch = input.charAt(i);

            if(ch == ' '){
                continue;
            }
         hm.put(ch, hm.getOrDefault(ch,0)+1);
        }

        return hm;
 //timecomplexity O(2n) --> O(n);
 //space O(k).  --> character in string      
    }

    private static Map<Character, Integer> getCountCharacterinStringWithInsertionOrder(String input){
        Map<Character, Integer> lhm = new LinkedHashMap<>();

        input = input.toLowerCase();

        for(int i =0;i<input.length();i++){

            char ch = input.charAt(i);

            if(ch == ' '){
                continue;
            }
            lhm.put(ch, lhm.getOrDefault(ch,0)+1);
        }

        return lhm;
    }

    private static Character firstRepeatingCharacterFromString(Map<Character, Integer> lhm){


        for(Map.Entry<Character,Integer> entry: lhm.entrySet()){
            if(entry.getValue() > 1){
                return entry.getKey();
            }
        }

        return null;
    }

    private static Character firstNonRepeatingCharacterFromString1(String input){
        Map<Character, Integer> hm = new HashMap<>();

        input = input.toLowerCase();

        for(int i = 0;i<input.length();i++){
            char ch = input.charAt(i);

            if(ch == ' '){
                continue;
            }
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }

        //second pass

        for(int i =0;i<input.length();i++){
            char ch = input.charAt(i);
            if(hm.get(ch)==1){
                return ch;
            }
        }
        return null;
    }

    public static void main(String [] args){
        String name = "Ram Eknath Gawas";

        countCharcterinString(name);
        Map<Character, Integer> hm = getcountCharcterinString(name);

        System.out.println(hm);

        Map<Character, Integer> lhm = getCountCharacterinStringWithInsertionOrder(name);
        System.out.println(lhm);

        char ch = firstRepeatingCharacterFromString(lhm);
        System.out.println(ch);

        char firstNonRepeating = firstNonRepeatingCharacterFromString1(name);
        System.out.println(firstNonRepeating);
    }
}
