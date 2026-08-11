class Solution {
    public int[] sortArray(int[] nums) {
       quickSort(nums, 0, nums.length - 1);
       return nums;
    }

    public void quickSort( int[] nums, int left, int right ) {
        if(left > right) return;

        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public int partition( int[] nums, int left, int right ){
        int pivot = nums[right];
        int prev = left - 1;

        for( int j = left; j < right; j++ ){
            if( nums[j] < pivot ){
                prev++;
                swap(nums, prev, j);
            }
        }
        swap(nums, ++prev, right);
        return prev;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}