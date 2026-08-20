class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

       for ( int asteroid: asteroids ){
            boolean survives = true;

            while( !stack.isEmpty() && asteroid < 0 && stack.peekLast() > 0) {
                if( stack.peekLast()  == -asteroid ){
                    stack.removeLast();
                    survives = false;
                    break;
                } else if( stack.peekLast() < -asteroid ){
                    stack.removeLast();
                } else {
                    survives = false;
                    break;
                }
            }
            if(survives) stack.addLast(asteroid);
       }

       return stack.stream().mapToInt(Integer::intValue).toArray();

    }
}