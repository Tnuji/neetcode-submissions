class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int i : piles)
        {
            right = Math.max(right, i);
        }

        while(left <= right)
        {
            int middle = left + (right - left) / 2;
            int hours = 0;

            for(int pile : piles)
            {
                hours += (pile + middle -1) / middle;
            }

            if(hours > h)
            {
                left = middle  + 1;
            }
            else{
                right = middle - 1;
            }
        }
        return left;
    }
}
