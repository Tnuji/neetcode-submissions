class Solution {
    public int maxArea(int[] heights) {
               int max = 0;
        int left = 0;
        int right = heights.length - 1;

        while(left < right)
        {
            int volume = (right - left) * Math.min(heights[right], heights[left]);
            if(max < volume) max = volume;

            if(heights[right] > heights[left])
            {
                ++left;
            }
            else{
                --right;
            }
        }
        return max;
    }
}
