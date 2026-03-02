package dailychallenge.Day15;

public class BestTimeToSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.print(maxProfit(prices));
    }
    public static int maxProfit(int[] prices)
    {
        int buyStock = Integer.MAX_VALUE;

        int profit = 0;

        for(int i : prices)
        {
            buyStock = Math.min(buyStock, i);

            profit = Math.max(profit, i - buyStock);
        }
        return profit;
    }
}