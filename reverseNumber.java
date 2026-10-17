import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class reverseNumber {
    
    public static void main(String [] args){

        System.out.println("Reverse a number");

        int number = 1200;

        int reverse = reverseNumber(number);
        System.out.println("Given number is = "+ number + " and reverse of that number is = "+ reverse);

        String reverseUsingString = reverseUsingString(number);
        System.out.println(reverseUsingString);

        //palindrome check
        int num = 12321;
        boolean isPalindrome = isNumberPalindrome(num);
        System.out.println("Given number is palindrome --> "+isPalindrome);

        //charcount usinsg hashmap
        String s = "Ram Gawas";
        countCharacterUsingHashmap(s);

        //primenumber
        int number1 = 8 ;
        System.out.println(isPrimeNumber(number1));
        // int [] primeNumbers = new int[100];
        ArrayList<Integer> primenumbers = new ArrayList();
        int index = 0;
        //print all the prime numbers from 1 to 100
        for(int i = 0;i<=100;i++){
            // if(isPrimeNumber(i)==true){
            //     primeNumbers[index] = i;
            //     index++;
            // }
            if(isPrimeNumber(i)==true){
                primenumbers.add(i);
            }
        }
        // System.out.println(Arrays.toString(primeNumbers));
        System.out.println(primenumbers);
    }

    private static int reverseNumber(int number) {
        
            int reverse = 0 ;

            while(number != 0){
                int lastdigit = number % 10;
                reverse = reverse * 10 + lastdigit;
                number = number/10;
            }
            return reverse;
    } 
    private static String reverseUsingString(int number){

            String reverseString = new StringBuilder(String.valueOf(number)).reverse().toString();
            return reverseString;
    }  

    private static boolean isNumberPalindrome(int number){

            boolean isPalindrome = false;
            int original = number;
            int reverse = 0;

            while( number != 0){
                int lastdigit = number % 10;
                reverse = reverse * 10 + lastdigit;
                number = number/10;
            }

            if(original == reverse){
                isPalindrome = true;
            }

            return isPalindrome;
    }

    private static void countCharacterUsingHashmap(String str){


            Map<Character, Integer> hm = new HashMap<>();

            for(int i = 0;i< str.length();i++){
            
            char ch = Character.toLowerCase(str.charAt(i));

                if(ch == ' '){
                    continue;
                }
                hm.put(ch, hm.getOrDefault(ch,0) +1);
            }
            for(Map.Entry<Character, Integer>entry : hm.entrySet()){
                if(entry.getValue()> 1){
                System.out.println("Key value is " + entry.getKey()+ "  --> "+ entry.getValue());
                }
            }

    }
    private static boolean isPrimeNumber(int input){
        boolean isPrime = true;

        if(input <= 1){
            isPrime = false;
        }
        if(input ==2){
            isPrime = true;
        }
        else if(input % 2 ==0){
            isPrime = false;
        }
        for(int i=3;i*1<input; i = i+2){
            if(input % i == 0){
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
