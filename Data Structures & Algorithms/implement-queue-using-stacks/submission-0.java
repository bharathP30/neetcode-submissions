class MyQueue {
    ArrayDeque<Integer> stack;
    public MyQueue() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.addLast(x);
    }
    
    public int pop() {
        if (stack.isEmpty()) throw new NoSuchElementException("Queue is empty");
        return stack.removeFirst();
    }
    
    public int peek() {
        if (stack.isEmpty()) throw new NoSuchElementException("Queue is empty");
        return stack.peekFirst();
    }
    
    public boolean empty()   {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */