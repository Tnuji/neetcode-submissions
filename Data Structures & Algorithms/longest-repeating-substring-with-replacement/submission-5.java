class Solution {
    public int characterReplacement(String s, int k) {
        int[] alphabet = new int[26];

        int left = 0;
        int longest = 0;
        char[] sArray = s.toCharArray();
        for(int right = 0; right < s.length(); ++right)
        {
            ++alphabet[sArray[right] - 65];

            int maxFreq = 0;

            for(int i : alphabet)
            {
                if(maxFreq  < i)
                {
                    maxFreq = i;
                }
            }

            while((right - left + 1) - maxFreq > k)
            {
                --alphabet[sArray[left] - 65];
                ++left;
            }
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
