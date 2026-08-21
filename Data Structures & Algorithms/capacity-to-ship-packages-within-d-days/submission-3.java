class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapPerDay = Arrays.stream(weights).max().getAsInt();
        int maxCapPerDay = Arrays.stream(weights).sum();

        while ( minCapPerDay <= maxCapPerDay ){
            int candidateCap = ( minCapPerDay + maxCapPerDay ) >>> 1;

            if( canShipAll(weights, candidateCap, days)){
                maxCapPerDay = candidateCap - 1;
            } else {
                minCapPerDay = candidateCap + 1;
            }
        }
            return minCapPerDay;
    }

    public boolean canShipAll(int[] weights, int candidate, int maxDays) {
        int days = 1;
        int cargoPerDay = 0;
        for( int weight: weights ){
            if( cargoPerDay + weight <= candidate ) cargoPerDay += weight;
            else {
                days++;
                cargoPerDay = 0;
                cargoPerDay += weight;
            }
        }
        return days <= maxDays;
    }
}