class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxWater = 0;

        while( left < right ){
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            int newMax = height * width;
            maxWater = Math.max(newMax, maxWater);

            if( heights[left] > heights[right] ) right--;
            else left++;
        } return maxWater;
    }
}
