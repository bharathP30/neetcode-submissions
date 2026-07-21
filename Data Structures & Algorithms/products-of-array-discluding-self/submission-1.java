class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int prefix = 1, suffix = 1;
        int [] resArray = new int[nums.length];

        for(int num = 0; num < nums.length; num++ ) {
            resArray[num] = prefix;
            prefix *= nums[num];
        }

        for(int num = nums.length - 1; num >= 0; num-- ) {
            resArray[num] *= suffix;
            suffix *= nums[num];
        }
        return resArray;
    }
}  
