class Solution {
    public int mySqrt(int x) {
        int low = 0, high = x;

        while ( low <= high ){
            int mid = ( low + high ) >>> 1;
            long sqMid = (long) mid * mid;

            if( sqMid == x ) return mid;
            else if ( sqMid < x ) low = mid + 1;
            else high = mid - 1;
        } return high;
    }
}