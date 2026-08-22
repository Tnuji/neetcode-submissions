class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min_stack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.min_stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty() || min_stack.peek() >= val)
        {
            min_stack.push(val);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(min_stack.peek()))
        {
            min_stack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}
