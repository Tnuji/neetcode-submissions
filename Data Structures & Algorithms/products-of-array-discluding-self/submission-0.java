class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int pre = 1;
        answer[0] = pre;
        for(int i = 1; i < nums.length; ++i)
        {
            answer[i] = nums[i - 1] * pre;
            pre = nums[i - 1] * pre; 
        }

        int post = 1;

        for(int i = nums.length - 2;0 <= i; --i)
        {
            post = nums[i + 1] * post;
            answer[i] = post * answer[i];
        }
        return answer;
    }
}  
