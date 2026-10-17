class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
    if(nums.length == 1) return result;
    this.nums = nums;
    dfs(0, target, new ArrayList<>());
    return result;

    }

    public void dfs(int start, int target, List<Integer> current)
    {
        if(target == 0) result.add(new ArrayList<>(current));
        if(target < 0) return;

        for(int i = start; i < nums.length; ++i)
        {
            current.add(nums[i]);
            dfs(i, target - nums[i], current);
            current.remove(current.size() - 1);
        }
    }
}
