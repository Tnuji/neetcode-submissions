class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] sArray = s.toCharArray();
 
        for(char c : sArray)
        {
            if(c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
                continue;
            }
            else if(stack.isEmpty()) 
            {return false;}
            
            char temp = stack.pop();
            if (c == ']' && temp != '['||
                   c == '}' && temp != '{'||
                   c == ')' && temp != '('){
                    return false;
                   }
        }
        return stack.isEmpty();
    }
}
