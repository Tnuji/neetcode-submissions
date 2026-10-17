class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0, new ArrayList<>());
        return result;
    }

    public void dfs(int start, List<Integer> current)
    {
        result.add(current);
        
        for(int i = start; i < nums.length; ++i)
        {
            current.add(nums[i]);
            dfs(i + 1, new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
    }
}
