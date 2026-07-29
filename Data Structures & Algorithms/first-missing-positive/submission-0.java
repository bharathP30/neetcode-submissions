class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            if(num > 0) set.add(num);
        }
        
        for(int num = 1; num < Integer.MAX_VALUE; num++){
            if(!set.contains(num)) return num;
        }
        return 1;
    }
}