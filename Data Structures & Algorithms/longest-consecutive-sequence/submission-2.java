class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> numsSorted = new TreeSet<>();

        for(int i : nums)
        {
            numsSorted.add(i);
        }

        int[] numsAgain = new int[numsSorted.size()];
        int index = 0;

        for(int num : numsSorted)
        {
            numsAgain[index++] = num;
        }

        int max = 1;
        int i = 1;
        
        while(i < numsAgain.length)
        {
            int j = i;
            int counter = 1;
            while(j < numsAgain.length && (numsAgain[j] - numsAgain[j-1]) == 1)
            {
                ++counter;
                ++j;
            }
            max = Math.max(max, counter);
            i = j + 1;
        } 
        return max;
    }
}
