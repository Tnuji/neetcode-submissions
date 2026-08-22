class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int prev = 10000;

        for(int i = 0; i < nums.length; ++i)
        {
            if(prev == nums[i] || nums[i] > 0) continue;
            prev = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right)
            {
                if((nums[i] + nums[left] + nums[right] ) == 0 )
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]); temp.add(nums[left]); temp.add(nums[right]);
                    if(!result.contains(temp))
                    {
                        result.add(temp);
                    }
                    ++left;
                    --right;
                }
                else if((nums[i] + nums[left] + nums[right] ) < 0)
                {
                    ++left;
                }
                else
                {
                    --right;
                }
            }
        }
        return result;
    }
}
