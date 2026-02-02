class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        long min = 0L, sum = 0L;
        int i=1, n = nums.length;
        k--;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->nums[a] - nums[b]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->nums[b] - nums[a]);
        Map<Integer,Boolean> map = new HashMap<>();
        for(i=1;i<=dist+1;i++) minHeap.offer(i);
        while(k > 0){
            int idx = minHeap.poll();
            sum += nums[idx];
            maxHeap.offer(idx);
            map.put(idx,true);
            k--;
        }
        min = sum;
        while(i<n){
            minHeap.offer(i);
            int rmvIdx = i-dist-1;
            if(map.containsKey(rmvIdx)){
                sum -= nums[rmvIdx];
                map.remove(rmvIdx);
                
                while(!minHeap.isEmpty() && minHeap.peek() <= rmvIdx) minHeap.poll();
                int idx = minHeap.poll();
                sum += nums[idx];
                map.put(idx,true);
                maxHeap.offer(idx);
                min = Math.min(min,sum);
                i++;
                continue;
            }
            while(!minHeap.isEmpty() && minHeap.peek() <= rmvIdx) minHeap.poll();
            while(!maxHeap.isEmpty() && maxHeap.peek() <= rmvIdx) maxHeap.poll();
            if(nums[maxHeap.peek()] > nums[minHeap.peek()]){
                int a = maxHeap.poll(), b = minHeap.poll();
                sum -= nums[a];
                map.remove(a);

                map.put(b,true);
                sum += nums[b];
                maxHeap.offer(b);
                minHeap.offer(a);
                
                min = Math.min(min,sum);
            }
            i++;
        }
        return min + (long)nums[0];
    }
}