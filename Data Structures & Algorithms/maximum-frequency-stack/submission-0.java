class FreqStack {
    Map<Integer, Integer> frequency;
    Map<Integer, Stack<Integer>> recency;
    int maxFreq;

    public FreqStack() {
        frequency = new HashMap<>();
        recency = new HashMap<>();    
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = frequency.getOrDefault(val, 0) + 1;
        frequency.put(val, freq);

        recency.computeIfAbsent(freq, f -> new Stack<>()).push(val);

        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        Stack<Integer> stack = recency.get(maxFreq);
        int val = stack.pop();
        frequency.put(val, frequency.get(val) - 1);
        if(stack.isEmpty()) maxFreq--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */