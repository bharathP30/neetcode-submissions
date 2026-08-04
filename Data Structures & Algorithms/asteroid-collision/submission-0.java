class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int asteriod : asteroids) {
            boolean isAlive = true;

            while (isAlive && asteriod < 0 && !stack.isEmpty() && stack.peekLast() > 0) {
                int top = stack.peekLast();

                if (-asteriod == top) {
                    stack.removeLast();
                    isAlive = false;
                } else if (-asteriod > top) {
                    stack.removeLast();
                } else {
                    isAlive = false;
                }
            }

            if( isAlive ) stack.addLast(asteriod);
        }

        int[] result = new int[stack.size()];
        int i = 0;
        for (int val : stack) {
            result[i++] = val;
        }
        return result;
    }
}