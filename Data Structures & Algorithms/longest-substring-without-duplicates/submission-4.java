class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        for(int i = 0; i < s.length(); ++i)
        {
            int j = i + 1;
            ArrayList<Character> subs = new ArrayList<>();
            subs.add(s.charAt(i));
            max = Math.max(max, subs.size());
            while(j < s.length() && !subs.contains(s.charAt(j)))
                {
                    subs.add(s.charAt(j));
                    max = Math.max(max, subs.size());
                    ++j;
                }
        }
        return max;
    }
}
