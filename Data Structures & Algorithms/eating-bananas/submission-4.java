class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minPerHour = 1;
        int maxPerHour = Arrays.stream(piles).max().getAsInt();

        while( minPerHour <= maxPerHour ){
            int candidateSpeed = ( minPerHour + maxPerHour ) >>> 1;

            if( canEatAllWithinTime(piles, candidateSpeed, h) ) {
                maxPerHour = candidateSpeed - 1;
            } else {
                minPerHour = candidateSpeed + 1;
            }
        }
            return minPerHour;
    }
    public boolean canEatAllWithinTime(int[] piles, int candidate, int maxHours){
        int hours = 0;

        for( int pile: piles ){
            hours += Math.ceil((double) pile/candidate);
        }
        return hours <= maxHours;
    }
}