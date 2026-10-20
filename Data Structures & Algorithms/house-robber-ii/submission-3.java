class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0] , nums[1]); 

        int[] maxl = new int[nums.length - 1];
        int[] maxr = new int[nums.length - 1];
        maxl[0] = nums[0];
        maxl[1] = Math.max(nums[0], nums[1]);


        for(int i = 2; i < nums.length - 1; ++i)
        {
            maxl[i] = Math.max(maxl[i-1], nums[i] + maxl[i - 2]);
        }
        
        maxr[0] = nums[1];
        maxr[1] = Math.max(nums[1] , nums[2]);

        for(int i = 2; i < nums.length - 1; ++i)
        {
            maxr[i] = Math.max(maxr[i-1], nums[i + 1] + maxr[i - 2]);
        }

        return Math.max(maxl[maxl.length - 1] , maxr[maxr.length-1]);
    }
}

