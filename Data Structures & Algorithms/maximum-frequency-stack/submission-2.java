class FreqStack {
    // keeping one stack and dynamically modifying it keeps the freq but loses recency
    // for that we need freq map and another group map with a stack, that groups the numbers based on their freq, since the numbers are stored as a stack, the most recent number with a freq is popped first when queried

    // we need, a map for freq, a map for group the elements based on their freq, in an recency order, and a max Var to pop the max freq numbers in recency order
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        // store freq of numbers
        int frequency = freq.getOrDefault(val, 0) + 1;
        freq.put(val, frequency);

        // keep the numbers in a stack based on their freq count
        group.computeIfAbsent(frequency, f -> new Stack<>());
        group.get(frequency).push(val);

        // update the maxFreq everytime
        maxFreq = Math.max(maxFreq, frequency);
    }
    
    public int pop() {
        int val =  group.get(maxFreq).pop();

        freq.put(val, freq.get(val) - 1);
        if(group.get(maxFreq).isEmpty()) maxFreq--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */