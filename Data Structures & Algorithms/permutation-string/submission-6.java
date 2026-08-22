class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){return false;}

        int s1_size = s1.length();
        int s2_size = s2.length();

        int[] s1_array = new int[26];
        int[] s2_array = new int[26];

        for(int i = 0; i < s1_size; ++i)
        {
            ++s1_array[s1.charAt(i) - 'a'];
            ++s2_array[s2.charAt(i) - 'a'];
        }

        for(int j = s1_size; j < s2_size; ++j)
        {
            if(Arrays.equals(s1_array, s2_array)) return true;
            --s2_array[s2.charAt(j - s1_size) - 'a'];
            s2_array[s2.charAt(j) - 'a']++;
        }
        if(Arrays.equals(s1_array, s2_array)) return true;
        return false;
    }
}
