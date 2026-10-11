class Solution {
    int[] globalnums;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        globalnums = nums;
        dfs(0, new ArrayList<>());
        return result;
    }

    public void dfs(int current, List<Integer> subset)
    {
        result.add(new ArrayList<>(subset));

        for(int i = current; i < globalnums.length; ++i)
        {
            subset.add(globalnums[i]);
            dfs(i + 1, subset);

            subset.remove(subset.size() - 1);
        }
    }
}
