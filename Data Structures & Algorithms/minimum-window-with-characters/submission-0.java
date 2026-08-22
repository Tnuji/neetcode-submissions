class Solution {
    public String minWindow(String s, String t) {
        int[] arr = new int[128];

        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();

        for(char c : t_array)
        {
            ++arr[c];
        }
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        int counter = 0;

        while(r < s_array.length)
        {
            char temp = s_array[r];
            if(--arr[temp] >= 0)
            {
                ++counter;
            }

            while(counter == t_array.length)
            {
                int curWindow = r - l + 1;
                if(curWindow < minLen)
                {
                    minLen = curWindow;
                    ans = s.substring(l, r + 1);
                }
                char leftchar = s_array[l];
                if(++arr[leftchar] > 0 ){
                    counter--;
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}
