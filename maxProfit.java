public class maxProfit {
    
    public static void main(String [] args){
        int [] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
/*

Input:
prices = [7,1,5,3,6,4]

Output:
5

Buy at 1
Sell at 6
Profit = 5*/
    private static int maxProfit(int [] prices){

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i =0;i< prices.length;i++){

            if(minPrice > prices[i]){
                minPrice = prices[i];
            }
            else{
                maxProfit = Math.max(maxProfit, prices[i]-minPrice);
            }
        }
        return maxProfit;
    }
}