class Solution {
    public int characterReplacement(String s, int k) {
      int left = 0;
      int[] alphabet = new int[26];
      int longest = 0;

      for(int right = 0; right < s.length(); ++right)
      {
        ++alphabet[s.charAt(right) - 65];
        int max = 0;

        for(int i : alphabet)
        {
            if(max < i) max = i;
        }

        while((right - left + 1) - max > k)
        {
            --alphabet[s.charAt(left) - 65];
            ++left;
        }

        longest = Math.max(longest, right - left + 1);
      }  
      return longest;
    }
}
