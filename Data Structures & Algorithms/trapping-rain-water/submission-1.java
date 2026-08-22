class Solution {
    public int trap(int[] height) {
        if(height.length == 1) return 0;

           int length = height.length;
    int[] maxLeft = new int[length];
    int[] maxRight = new int[length];

    maxLeft[0] = 0;
    maxRight[length - 1] = 0;
    int max = 0;
    for(int i = 1; i < length; ++i)
    {
        max = max = Math.max(max, height[i-1]);
        maxLeft[i] = max;
    }

    max = 0;
    for(int i = length - 2; 0 <= i; --i)
    {
        max = max = Math.max(max, height[i+1]);
        maxRight[i] = max;
    }

    int sum= 0;

    for(int i = 0; i < length; ++i)
    {
        int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
        if(water <= 0) continue;
        sum += water;
    }

    return sum;
    }
}

