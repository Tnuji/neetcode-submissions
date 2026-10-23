class Solution {
    public int coinChange(int[] coins, int amount) {

    int[] beforeme = new int[amount + 1];

    Arrays.fill(beforeme, amount + 1);

    beforeme[0] = 0;

    for(int i = 1; i <= amount; ++i)
    {
        for(int j : coins)
        {
            if(j <= i)
            {
                beforeme[i] = Math.min(beforeme[i] , beforeme[i - j] + 1);
            }
        }
    }
        

    if(amount < beforeme[amount]) return -1;
    return beforeme[amount];
    }
}
