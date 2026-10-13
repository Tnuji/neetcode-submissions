class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] numsG;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        numsG = nums;
        Arrays.sort(numsG);
        dfs(0 , new ArrayList<>());
        return result;
    }

    public void dfs(int start, List<Integer> current)
    {
        result.add(current);

        for(int i = start; i < numsG.length; ++i)
        {
            if(i > start && numsG[i] == numsG[i - 1]) continue;
            current.add(numsG[i]);
            dfs(i + 1, new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
    }
}
