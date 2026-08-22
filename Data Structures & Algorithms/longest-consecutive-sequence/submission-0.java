class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        for(int i : nums)
        {
            set.add(i);
        }

        for(Integer i : set)
        {
            if(!set.contains(i - 1))
            {
                int count = 1;
                int curr = i;
                while(set.contains(curr + 1))
                {
                    curr = curr + 1;
                    ++count;
                }
                if (longest < count)
                {
                    longest = count;
                }
            }
        }
        return longest;
    }
}
