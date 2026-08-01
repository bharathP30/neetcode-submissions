class Solution {
    public int calPoints(String[] operations) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String s : operations) {
            if (s.equals("+")) {
                int top = stack.pop();
                int newTop = stack.peek();
                int sum = top + newTop;
                stack.push(top);
                stack.push(sum);
            } else if (s.equals("C"))
                stack.pop();
            else if (s.equals("D"))
                stack.push(2 * stack.peek());
            else
                stack.push(Integer.parseInt(s));
        }

        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }
}