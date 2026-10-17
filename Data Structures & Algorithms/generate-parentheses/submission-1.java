class Solution {
    List<String> result = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0,0,new StringBuilder());
        return result;
    }

    public void dfs(int open, int close,StringBuilder current)
    {
        if(current.length() == n * 2)
        {
            result.add(current.toString());
            return;
        }

        if(open < n)
        {
            current.append("(");
            dfs(open + 1, close, current);
            current.deleteCharAt(current.length() - 1);
        }
        if(close < open)
        {
            current.append(")");
            dfs(open , close + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
