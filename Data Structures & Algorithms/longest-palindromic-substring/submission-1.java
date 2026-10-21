class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        int maxCount = 0;

        for(int i = 0; i < s.length(); ++i)
        {
            int left = i; 
            int right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
            {
            
                    if((right - left + 1) > maxCount)
                    {
                        maxCount = right - left + 1;
                        answer = s.substring(left, right + 1);
                    }
                
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
                
                    if((right - left + 1) > maxCount)
                    {
                        maxCount = right - left + 1;
                        answer = s.substring(left, right + 1);
                    }
            
                --left;
                ++right;
            }
        }    

        return answer;
    }
}
