class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;

        int palindromes = 0;

        for(int i = 0; i < s.length(); ++i)
        {
            int left = i;
            int right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                ++palindromes;
                --left;
                ++right;
            }
        }

        for(int i = 0; i < s.length(); ++i)
        {
            int left = i;
            int right = i + 1;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
                ++palindromes;
                --left;
                ++right;
            }
        }

        return palindromes;
    }
}
