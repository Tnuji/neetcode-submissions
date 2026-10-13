class Solution {
    int[] nums;
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        dfs(0 , target, new ArrayList<>());
        return result;
    }

    public void dfs(int start, int target, List<Integer> current)
    {
        if(target == 0) result.add(current);
        if(target < 0) return;

        for(int i = start ; i < nums.length; ++i)
        {
            current.add(nums[i]);
            dfs(i , target - nums[i], new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
    }
}
