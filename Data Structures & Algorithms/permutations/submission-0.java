class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        dfs(new ArrayList<>());
        return result;
    }

    public void dfs(List<Integer> current)
    {
        if(current.size() == nums.length) 
        {
            result.add(current);
            return;
        }

        for(int i : nums)
        {
            if(current.contains(i)) continue;

            current.add(i);
            dfs(new ArrayList<>(current));
            current.remove(current.size() - 1);
        }

    }
}
