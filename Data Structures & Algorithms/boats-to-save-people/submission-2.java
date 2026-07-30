class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        int boat = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++; // thin person goes, only if there's room left on the boat
            }
            right--; // fat person always goes
            boat++;
        }
        return boat;
    }
}