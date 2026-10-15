class Solution {
    List<List<String>> result = new ArrayList<>();
    String global;
    public List<List<String>> partition(String s) {
        global = s;
        dfs(0, new ArrayList<>());
        return result;
    }

    public void dfs(int start, List<String> current)
    {
        if(start == global.length())
        {
            result.add(current);
            return;
        }

        for(int i = start; i < global.length(); ++i)
        {
            String substring = global.substring(start, i + 1);
            if(isPalindrome(substring)){
             current.add(substring);
            dfs(i + 1, new ArrayList<>(current));
            current.remove(current.size() -1 );
            }
        }
    }

    public boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;

        while(left <= right)
        {
            if(s.charAt(left) != s.charAt(right)) return false;
            ++left;
            --right;
        }
        return true;
    }
}
