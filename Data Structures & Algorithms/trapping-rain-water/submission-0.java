class Solution {
    public int trap(int[] height) {
        int[] before = new int[height.length];
        int[] after = new int [height.length];
        int left = 0;
        int right = 0;

        for( int i = 0 ; i < before.length; ++i)
        {
            before[i] = left;
            left = Math.max(left, height[i]);
        }
        for( int i = after.length - 1; 0 <= i; --i)
        {
            after[i] = right;
            right = Math.max(right, height[i]);
        }

        int sum = 0;
        for(int i = 0; i < height.length; ++i)
        {
            int pot = Math.min(before[i], after[i]);
            sum+= Math.max(0, pot - height[i]);
        }
        
        return sum;

    }
}
 