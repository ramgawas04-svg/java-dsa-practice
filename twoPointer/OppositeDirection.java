
package twoPointer;

import java.util.Arrays;

public class OppositeDirection{


    public static int[] twoPoint(int [] arr, int target){

        int left = 0 ;
        int right = arr.length -1;

        while(left<right){

                int currentSum = arr[left] + arr[right];

                if (currentSum==target){
                    return new int[]{left+1, right+1};
                }
                else if (currentSum < target){
                    left++;
                }else{
                    right--;
                }
        }
        return new int[]{-1, -1};
    }

    public static String reverseString(String inputString){

        String result = "";

        int left = 0;
        int right = inputString.length()-1;
        char [] charArray = inputString.toCharArray();

        while(left < right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
       // result = Arrays.toString(charArray);
        return  new String(charArray);
    }

    public static boolean ispalindrome(String input){

        int left = 0;
        int right = input.length()-1;
        char [] charArray = input.toCharArray();
        boolean isPalindrome = false;
        while(left < right){
            if(charArray[left] != charArray[right]){
                return false;

            }else{
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String [] args){

        System.out.println("Two pointers");
        int [] numbers = {1,2,3,4,5,6,7,9,10};
        int target = 15;

        int [] sum = twoPoint(numbers, target);
        System.out.println(sum[0] + " "+ sum[1]);

        String name = "oppositeDirection";

        String result= reverseString(name);

        System.out.println(result);

        String input = "gawsg";
        boolean isPalindrome = ispalindrome(input);
        System.out.println(isPalindrome);

    }
}