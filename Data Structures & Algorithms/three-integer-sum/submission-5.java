class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        ArrayList<List<Integer>> answer = new ArrayList<>();

        int prev = 90000;
        for(int i = 0; i < nums.length; ++i)
        {
            if(nums[i] == prev || nums[i] > 0)continue;

            prev = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right)
            {
                if((nums[i] + nums[left] + nums[right]) == 0)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    if(!answer.contains(temp)) answer.add(temp);
                    --right;
                    ++left;
                }
                else if ((nums[i] + nums[left] + nums[right]) > 0)
                {
                    --right;
                }
                else{
                    ++left;
                }
            }

        } 
        return answer;
    }
}
