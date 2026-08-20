class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        Arrays.fill(answers, 0);

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for( int i = 1; i < temperatures.length; i++ ){
            while( !stack.isEmpty() && temperatures[stack.peek()] < temperatures[i] ){
                answers[stack.peek()] = i - stack.peek();
                stack.pop();
            } stack.push(i);
        } return answers;
    }
}