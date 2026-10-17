class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        dfs(0, new ArrayList<>());
        return result;
    }

    public void dfs(int start, List<Integer> current)
    {
        result.add(new ArrayList<>(current));
        for(int i = start; i < nums.length; ++i)
        {
            if(i > start && nums[i] == nums[i-1]) continue;
            current.add(nums[i]);
            dfs(i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
