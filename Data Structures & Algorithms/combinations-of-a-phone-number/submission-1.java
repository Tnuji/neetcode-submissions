class Solution {
    List<String> result = new ArrayList<>();
    String word;
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
        word = digits;
        dfs(0, new StringBuilder());
        return result;
    }

    public void dfs (int start, StringBuilder sb)
    {
        if(sb.length() == word.length())
        {
            result.add(sb.toString());
            return;
        }

        String letter = matches[word.charAt(start) - '0'];

        for(char c : letter.toCharArray())
        {
            sb.append(c);
            dfs(start + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }


    }
}
