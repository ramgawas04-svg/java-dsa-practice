package binarySearch;

public class BinarySearch{


    public static void main(String [] args){

        //find the index of a target value 

        int [] nums = {1,1,2,2,2,6,7,8,9};
        int target = 2;
        int index = binarySearch(nums, target);
        int firstindex = firstOccurance(nums, target);
        System.out.println("Index of " +target + " is " + index);
        System.out.println("First index(first occurance) of " +target + " is " + firstindex);
        int lastocc = lastOccurance(nums, target);
        System.out.println("Last index(last) occurance) of " +target + " is " + lastocc);

    }

    public static int binarySearch(int [] arr, int target){

        int left = 0 ;
        int right = arr.length -1;

        while(left <= right){
            int mid = left +(right - left )/2;

            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }

    //first occurance
    public static int firstOccurance(int [] arr, int target){
        int left = 0;
        int right = arr.length -1;
        int ans = 0;

        while (left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]>=target){
                ans = mid;
                right = mid -1;
            }else {
                left = mid +1;
            }

        }  
        return ans;
    }
    public static int lastOccurance(int [] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int ans = 0;
        
            while(left<=right){
                int mid = left + (right-left)/2;

                if(arr[mid]<=target){
                    ans = mid;
                    left = mid+ 1;
                }
                else{
                    right = mid -1;
                }
            }

            return ans;
        }
}
