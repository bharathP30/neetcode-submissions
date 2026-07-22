class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for( int i : nums ){
            minHeap.add(i);
            if(minHeap.size() > k) minHeap.poll(); 
        } return minHeap.poll();
    }
}
