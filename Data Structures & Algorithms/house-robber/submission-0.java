class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] most = new int[nums.length];
        most[0] = nums[0];
        most[1] = Math.max(nums[1], nums[0]);

        for(int i = 2; i < nums.length; ++i)
        {
            most[i] = Math.max(most[i-1], nums[i] + most[i-2]);
        }

        return most[nums.length - 1];
    }
}
