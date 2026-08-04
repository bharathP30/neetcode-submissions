class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];

        for ( int i = 0; i < n ;i++){
            int j = i + 1;
            while ( j < n ){
                if( temperatures[j] > temperatures[i]) {
                    arr[i] = j - i; 
                    break;
                } else arr[i] = 0;

                j++;
            }
        } return arr;
    }
}