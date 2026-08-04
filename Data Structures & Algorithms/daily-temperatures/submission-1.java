class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for ( int i = 0; i < n; i++ ) {
            while ( !stack.isEmpty() && temperatures[i] > temperatures[stack.peekLast()] ){
               int idx = stack.pollLast();
               arr[idx] = i - idx;
            }
            stack.addLast(i);

        } return arr;
    }
}