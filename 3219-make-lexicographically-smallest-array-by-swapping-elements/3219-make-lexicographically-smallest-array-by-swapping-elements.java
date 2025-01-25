class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length,index=0;
        int[][] arr=new int[n][2];
        int[] res=new int[n];
        List<PriorityQueue<Integer>> pq=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) arr[i]=new int[]{nums[i],i};
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int maxLimit=nums[0]+limit;
        for(int i=0;i<n;i++){
            if(maxLimit>=arr[i][0]){
                if(index==pq.size()) pq.add(new PriorityQueue<>());
                pq.get(index).add(arr[i][0]);
                map.put(arr[i][1],index);
            }else{
                index++;
                if(index==pq.size()) pq.add(new PriorityQueue<>());
                pq.get(index).add(arr[i][0]);
                map.put(arr[i][1],index);
            }
            maxLimit=arr[i][0]+limit;
        }
        for(int i=0;i<n;i++){
            index=map.get(i);
            res[i]=pq.get(index).poll();
        }
        return res;
    }
}