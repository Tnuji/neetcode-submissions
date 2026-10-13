class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        nums = candidates;
        Arrays.sort(nums);
        dfs(0, target, new ArrayList<>());
        return result;
    }

    public void dfs(int start, int target, List<Integer> current)
    {
        if(target == 0)
        {
            result.add(current);
            return;
        }
        if(target < 0) return;

        for(int i = start; i < nums.length; ++i)
        {
            if(i > start && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            dfs(i + 1, target-nums[i], new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
    }
}
