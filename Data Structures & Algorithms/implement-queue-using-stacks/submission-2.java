class MyQueue {
    ArrayDeque<Integer> pushStack;
    ArrayDeque<Integer> popStack;
    public MyQueue() {
        pushStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        change();
        if (popStack.isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return popStack.pop();
    }

    public int peek() {
        change();
        if (popStack.isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return popStack.peek();
    }

    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

    public void change() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
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