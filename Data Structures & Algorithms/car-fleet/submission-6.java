class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        Deque<Double> stack = new ArrayDeque<>();

        for( int index = 0; index < position.length; index++){
            cars[index][0] = position[index];
            cars[index][1] = (double) ( target -  position[index] )  / speed[index];
        }

        Arrays.sort(cars, (a, b) -> (Double.compare(b[0], a[0])));

        for( double[] car : cars ){
            double time = car[1];
            if(stack.isEmpty() || stack.peek() < time ) stack.push(time);
        }

        return stack.size();
    }
}
