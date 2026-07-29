// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         Set<Integer> set = new HashSet<>();

//         for(int num : nums){
//             if(num > 0) set.add(num);
//         }
        
//         for(int num = 1; num < Integer.MAX_VALUE; num++){
//             if(!set.contains(num)) return num;
//         }
//         return 1;
//     }
//}
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
