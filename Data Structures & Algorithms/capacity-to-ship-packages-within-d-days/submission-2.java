class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCap = Arrays.stream(weights).max().getAsInt();
        int maxCap = Arrays.stream(weights).sum();

        while( minCap <= maxCap ){
            int candidateCap = ( minCap + maxCap ) >>> 1;

            if(canCarryAll(weights, candidateCap, days)){
                maxCap = candidateCap - 1;
            } else {
                minCap = candidateCap + 1;
            }
            
        } return minCap;
    }

    public boolean canCarryAll (int[] weights, int candidate, int days) {
        int noOfDays = 1;
        int dailyCargo = 0;
        for( int weight : weights ){
            if(dailyCargo + weight > candidate) {
                noOfDays++;
                dailyCargo = 0;
                dailyCargo += weight;
            }
            else dailyCargo += weight;
        }
        return noOfDays <= days;
    }
}