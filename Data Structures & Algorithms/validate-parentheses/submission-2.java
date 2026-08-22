class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); ++i)
        {
            char c = s.charAt(i);
            
            if(c == '{' || c == '[' | c == '(')
            {
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;

                char temp = stack.pop();
                if(c == ']' && temp != '['||
                   c == '}' && temp != '{'||
                   c == ')' && temp != '(') return false;
            }

        }
        return stack.isEmpty();
    }
}
