class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;

        int beforeMe = 1;
        int doubleBefore = 1;

        for(int i = 1; i < s.length(); ++i)
        {
           int curr = 0;
           if(s.charAt(i) != '0')
           {
            curr += beforeMe;
           } 

           int pastwo = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');

           if(pastwo >= 10 && pastwo <= 26)
           {
                curr += doubleBefore; 
           }

           doubleBefore = beforeMe;
           beforeMe = curr;
        }
        return beforeMe;
    }
}
