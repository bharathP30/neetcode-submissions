class MinStack {
    ArrayDeque<Integer> mainStack;
    ArrayDeque<Integer> minStack;

    public MinStack() {
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        mainStack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
        } 
    }

    public void pop() {
        if (mainStack.isEmpty())
            throw new NoSuchElementException("Stack is empty");
        int removed = mainStack.pop();
        if (removed == minStack.peek())
            minStack.pop();
    }

    public int top() {
        if (mainStack.isEmpty())
            throw new NoSuchElementException("Stack is empty");
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            throw new NoSuchElementException("Stack is empty");
        return minStack.peek();
    }
}
