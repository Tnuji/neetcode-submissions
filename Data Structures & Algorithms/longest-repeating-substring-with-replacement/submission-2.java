class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] letters = new int[26];

        int left = 0;
        int maxLength = 0;

        for(int r = 0; r < s.length(); ++r)
        {
            ++letters[s.charAt(r) - 'A'];
            int maxFreq = 0;

            for(int i : letters)
            {
                if(maxFreq  < i)
                {
                    maxFreq = i;
                }
            }
            while((r-left + 1) - maxFreq > k )
            {
                --letters[s.charAt(left) - 'A'];
                ++left;

                maxFreq = 0;

                for(int i : letters)
                {
                    if(maxFreq  < i)
                    {
                        maxFreq = i;
                    }
                }
            }
            maxLength = Math.max(maxLength, r - left + 1);
        }
        return maxLength;
    }
}
