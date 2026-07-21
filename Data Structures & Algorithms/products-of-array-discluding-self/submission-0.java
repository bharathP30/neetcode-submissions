class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int prefix = 1, suffix = 1;
        int [] prefixArray = new int[nums.length];
        int [] suffixArray = new int[nums.length];
        int [] resArray = new int[nums.length];

        for(int num = 0; num < nums.length; num++ ) {
            prefixArray[num] = prefix;
            prefix *= nums[num];
        }

        for(int num = nums.length - 1; num >= 0; num-- ) {
            suffixArray[num] = suffix;
            suffix *= nums[num];
        }

        for (int i = 0; i < nums.length; i++) {
            resArray[i] = prefixArray[i]*suffixArray[i];
        }
        return resArray;
    }
}  
