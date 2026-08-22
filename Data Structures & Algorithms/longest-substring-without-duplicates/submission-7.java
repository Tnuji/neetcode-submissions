class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        char[] sArray = s.toCharArray();
        HashSet<Character> substring = new HashSet<>();
        int longest = 0;
        while(right < s.length())
        {
            while(substring.contains(sArray[right]))
            {
                substring.remove(sArray[left]);
                ++left;
            }
            substring.add(sArray[right]);
            longest = Math.max(longest, right - left + 1);
            ++right;
        }
        return longest;
    }
}
