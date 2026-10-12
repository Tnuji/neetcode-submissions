class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] globalnums;
    public List<List<Integer>> subsets(int[] nums) {
        globalnums = nums;
        dfs(0 , new ArrayList<>());
        return result;
    }

    public void dfs(int start, List<Integer> current)
    {
        result.add(current);

        for(int i = start; i < globalnums.length; ++i)
        {
            current.add(globalnums[i]);
            dfs(i + 1, new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
    }


}
