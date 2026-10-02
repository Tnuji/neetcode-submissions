class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;
        for(int right = 1; right < prices.length; ++right)
        {
            while(prices[right] < prices[left]){
                ++left;
            }
            max = Math.max(max, prices[right] - prices[left]);
        }
        return max;
    }
}
