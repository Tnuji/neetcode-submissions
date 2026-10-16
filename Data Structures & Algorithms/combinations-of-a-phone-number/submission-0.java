class Solution {
    List<String> result = new ArrayList<>();
    String global;
    String[]  matches = {
    "",     // 0
    "",     // 1
    "abc",  // 2
    "def",  // 3
    "ghi",  // 4
    "jkl",  // 5
    "mno",  // 6
    "pqrs", // 7
    "tuv",  // 8
    "wxyz"  // 9
    };
    public List<String> letterCombinations(String digits) {
        
    if(digits.length() == 0) return result;
    global = digits;
    dfs(0, new StringBuilder());
    return result;
    }

   public void dfs(int index, StringBuilder sb)
    {
        if(index == global.length()){
         result.add(sb.toString());
         return;
        }

        String choices = matches[global.charAt(index) - '0'];

        for(char c : choices.toCharArray())
        {
            sb.append(c);
            dfs(index + 1, new StringBuilder(sb));
            sb.deleteCharAt(sb.length() - 1);
        }


    }
}
