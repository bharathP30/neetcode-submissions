class Solution {
    public int removeDuplicates(int[] nums) {
        int write = 0;
        int read = 0;

        while ( write < nums.length ){
            if( nums[write] != nums[read] ) {
                read++;
                swap(nums, write, read);
            }
            write++;
        } return read + 1;
    }

    public void swap( int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}