class MinStack {

    Deque<Integer> stack ;
    Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek()))
        {
            stack.pop();
            minStack.pop();
            
        }
        else{
            stack.pop();
        }
    }
    
    public int top() {
        int val = stack.peek();
        return val;
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
