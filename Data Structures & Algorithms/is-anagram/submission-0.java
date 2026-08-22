class Solution {
    public boolean isAnagram(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        if(first.length != second.length) return false;

        int[] count = new int[26];
        for(char c : first)
        {
            ++count[c - 'a'];
        }
        for(char c : second)
        {
            --count[c - 'a'];
        }

        for(int i : count)
        {
            if(i != 0)
            {
                return false;
            }
        }
        return true;
    }
}
