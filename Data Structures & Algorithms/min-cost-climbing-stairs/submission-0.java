class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2) return Math.min(cost[0] , cost[1]);

        int[] howmajj = new int[cost.length + 1];
        howmajj[0] = 0;
        howmajj[1] = 0;

        for(int i = 2; i < howmajj.length; ++i)
        {
            howmajj[i] = Math.min(howmajj[i-1] + cost[i - 1],howmajj[i-2] + cost[i - 2] );
        }

        return howmajj[howmajj.length - 1];
    }
}
