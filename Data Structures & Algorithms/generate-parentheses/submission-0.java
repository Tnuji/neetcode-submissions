class Solution {
    
    List<String> result = new ArrayList<>();
    int nG;
    public List<String> generateParenthesis(int n) {
        nG = n;
        StringBuilder sb = new StringBuilder("");
        dfs(0,0,sb);
        return result;
    }

    public void dfs(int open, int close, StringBuilder current)
    {
        if(current.length() == (nG * 2)) result.add(current.toString());

        if(open < nG)
        {
            current.append("(");
            dfs(open + 1, close, current);
            current.deleteCharAt(current.length() - 1);
        }

        if(close < open)
        {
            current.append(")");
            dfs(open, close + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
