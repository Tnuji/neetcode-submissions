class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> value_index = new HashMap<>();

        for(int i =0; i < nums.length; ++i)
        {
            if(value_index.containsKey(target - nums[i]))
            {
                return new int[]{value_index.get(target - nums[i]), i};
            }
            value_index.put(nums[i], i);
        }
        return new int[]{0};
    }
}
