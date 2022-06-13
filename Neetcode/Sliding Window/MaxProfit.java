public class MaxProfit {
    public int maxProfitMethod(int[] prices) {
        int profit = 0;
        int buy = prices[0];

        for (int price : prices) {
            if (price < buy)
                buy = price;
            else
                profit = profit > price - buy ? profit : price - buy;
        }

        return profit;
    }
}
