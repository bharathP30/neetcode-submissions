class Solution {
    maxSlidingWindow(nums, k) {
        // moronic approach is using DeQueue
        let res = [];
        let deq = [];
        
        for ( let i = 0; i < nums.length; i++ ){
            if ( deq.length && deq[0] <= i - k ) deq.shift();
            while ( deq.length && nums[deq[deq.length - 1]] < nums[i]) deq.pop();
            deq.push(i);
            if(i >= k - 1) res.push(nums[deq[0]]);
        } return res;
    }
}
