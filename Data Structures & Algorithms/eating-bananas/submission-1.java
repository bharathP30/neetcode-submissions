class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1, maxSpeed = Arrays.stream(piles).max().getAsInt();
        // 1 or max in the piles
        // basically, for binary search on answer problems does not require you to perform binary search on the given array but rather on the possible answers, possible values might exist in the given array and might not also exist. 

        while (minSpeed <= maxSpeed) {
            int candidateSpeed = (minSpeed + maxSpeed) >>> 1;

            if (canEatAllBananas(piles, candidateSpeed, h)) {
                maxSpeed = candidateSpeed - 1;
            } else {
                minSpeed = candidateSpeed + 1;
            }
        }
            return minSpeed;
    }

    public boolean canEatAllBananas(int[] piles, int speed, int totalTime) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / speed);
        }
        return hours <= totalTime;
    }
}