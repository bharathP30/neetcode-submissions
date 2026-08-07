class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        int first = 0, last = ROWS * COLS - 1;

        while ( first <= last ){
            int mid = (first + last) >>> 1;

            int row = mid / COLS, col = mid % COLS;
            if( target > matrix[row][col] ) first = mid + 1;
            else if ( target < matrix[row][col] ) last = mid - 1;
            else return true;
        } return false;
    }
}
