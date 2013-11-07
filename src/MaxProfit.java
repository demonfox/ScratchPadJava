
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        
        int currMax = 0;
        int currBuy = prices[0];
        int currSell = currBuy;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < currBuy) {
                currBuy = prices[i];
                currSell = currBuy;
            } else if (prices[i] > currSell) {
                int profit = prices[i] - currBuy;
                if (profit > currMax)
                    currMax = profit;
            }
        }
        
        return currMax;
    }
    
    public int maxProfit2(int[] prices) {
    	return 1;
    	/*
        if (prices.length <= 1)
            return 0;
        
        int totalProfit = 0;
        int prevPrice = prices[0];
        int currBuy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prevPrice && prevPrice > currBuy) {
                totalProfit += (prevPrice - currBuy);
                currBuy = prices[i];
                prevPrice = prices[i];
            } else if (prices[i] < currBuy) {
                currBuy = prices[i];
                prevPrice = prices[i];
            } else 
            prevPrice = prices[i];
        }
        
        if (prevPrice > currBuy)
            totalProfit += (prevPrice - currBuy);
        
        return totalProfit;
    }
        
        return currMax;
        */
    }
    
    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit2(new int[] {1, 2}));
    }
}
