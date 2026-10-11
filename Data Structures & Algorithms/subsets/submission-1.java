class Solution {
    //lets make these global for the recursion in dfs
    int[] nums;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0, new ArrayList<>());
        return result;
    }

    //here what i'm basically doing is looping though each value in nums and recursively making lists
    // start with index 0 then 1 but each time I go to the next for the recursion I send a copy 
    public void dfs(int start, List<Integer> current)
    {
        result.add(current);

        for(int i = start; i < nums.length; ++i)
        {
            current.add(nums[i]);
            dfs(i + 1, new ArrayList<>(current));

            //here remove the last index to go back to the last list confusing asf ngl lmao
            current.remove(current.size() - 1);
        }
    }
}
