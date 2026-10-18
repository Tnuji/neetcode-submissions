class Solution {
    List<List<String>> result = new ArrayList<>();
    String word;
    public List<List<String>> partition(String s) {
        word = s;
        dfs(0, new ArrayList<>());
        return result;
    }

    public void dfs(int start, List<String> current)
    {
        if(start == word.length())
        {
            result.add(current);
            return;
        }

        for(int i = start; i < word.length(); ++i)
        {
            if(isPalindrome(word.substring(start, i + 1)))
            {
                current.add(word.substring(start,i+1));
                dfs(i + 1, new ArrayList<>(current));
                current.remove(current.size() - 1);
            }
        }



    }
    public boolean isPalindrome(String word)
    {
        int left =0;
        int right = word.length() - 1;

        while(left <= right)
        {
            if(word.charAt(left) != word.charAt(right)) return false;
            ++left;
            --right;
        }  
        return true;
    }
}
