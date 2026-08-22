class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String s : tokens)
        {
            if(s.equals("*") || s.equals("-") || s.equals("+") || s.equals("/"))
            {
                int a = stack.pop();
                int b = stack.pop();
                int result = 0;
                switch(s)
                {
                    case "*":
                        result = b * a;
                        break;
                    case "+":
                        result = b + a;
                        break;
                    case "-":
                        result = b - a;
                        break;
                    case "/":
                        result = b / a;
                        break;
                }

                stack.push(result);
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
