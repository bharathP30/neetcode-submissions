class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length - 1;
        int left = 0, right = n;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            if( nums[mid] == target) return true;
            else if ( nums[mid] == nums[left] && nums[mid] == nums[right]){
                left++;
                right--;
            } else if( nums[mid] <= nums[right]){
                if(target >= nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                if(target <= nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return false;
    }
}