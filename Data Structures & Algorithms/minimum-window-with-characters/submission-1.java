class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int[] alphabet = new int[128];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for(char c : tArray)
        {
            ++alphabet[c];
        }

        int counter = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        String answer = "";

        for(int right = 0; right < s.length(); ++right)
        {
            char temp = sArray[right];
            if(--alphabet[temp] >= 0 )
            {
                ++counter;
                while(counter == t.length())
                {
                    int length = right - left + 1;
                if(length < minLen)
                {
                    minLen = length;
                    answer = s.substring(left, right + 1);
                }
                    if(++alphabet[sArray[left]] > 0)
                    {
                        --counter;
                    }
                    ++left;
                }
            }
        }
        return answer;
    }
}
