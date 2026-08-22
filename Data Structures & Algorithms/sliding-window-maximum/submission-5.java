class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //TreeSet<Integer> max = new TreeSet<>();
        TreeSet<int[]> max = new TreeSet<>(
    (a, b) -> {
        if (a[0] != b[0])
            return Integer.compare(a[0], b[0]);

        return Integer.compare(a[1], b[1]);
    }
);
        int[] answer = new int[nums.length - k + 1];

        for(int i = 0; i < k; ++i)
        {
            max.add(new int[]{nums[i] , i});
        }
        answer[0] = max.last()[0];
        int answerIndex = 1;
        int left = 0;
        int repeat = 0;
        for(int right = k; right < nums.length; ++right)
        {
            max.remove(new int[]{nums[left] , left});
            //if(max.contains(nums[right])) max.remove(nums[right]);
            //if(max.contains(nums[right])){}
            max.add(new int[]{nums[right] , right});
            answer[answerIndex] = max.last()[0];
            ++answerIndex;
            ++left;
        }

        return answer;
    }
}
