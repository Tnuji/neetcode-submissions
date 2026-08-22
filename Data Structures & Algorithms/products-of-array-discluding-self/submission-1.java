class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] answer = new int[nums.length];

        int pre  = 1;
        answer[0] = 1;

        for(int i = 1; i < nums.length; ++i)
        {
            pre = pre * nums[i-1];
            answer[i] = pre;
        }

        int post = 1;

        for(int i = nums.length - 2; i >= 0; --i)
        {
            post = post * nums[i + 1];
            answer[i] = answer[i] * post;
        }

        return answer;
    }
}  
