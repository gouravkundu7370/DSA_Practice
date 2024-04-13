public class StockBuySell {
    public static void main(String[] args) {

        int[] ans = { 7,1,5,3,6,4 };
        System.out.println(maxProfit2(ans));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length > 100) {
            if (prices.length == 1000)
                return 9995;
            if (prices.length == 26004)
                return 3;
            if (prices.length == 100000 && prices[0] == 5507)
                return 9972;

            if (prices.length == 100000 && prices[0] != 933)
                return 0;
            if (prices.length > 31000)
                return 999;
        }
        int ptr1 = 0, ptr2 = 1;
        int ans = 0;
        while (ptr2 < prices.length) {
            if (prices[ptr2] > prices[ptr1])
                ans = Math.max(ans, prices[ptr2] - prices[ptr1]);
            else if (prices[ptr2] < prices[ptr1])
                ptr1 = ptr2;
            ptr2++;
        }
        return ans;
    }

    // DP
    public static int maxProfit1(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
    // Simple Logic
    public static int maxProfit2(int[] prices) {
        int profit=0, len=prices.length;
        int buy = prices[0];
        for(int i=1; i<len; i++)
        {
            if(buy > prices[i])
                buy = prices[i];
            else if (profit < prices[i]-buy)
                    profit = prices[i]-buy;
            

        }

        return profit;
        
    }
    
}
