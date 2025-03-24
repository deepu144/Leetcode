class Solution {
    public int countDays(int days, int[][] meetings) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int n=meetings.length,prev=-1,count=0,sum=0;
        for(int[] meet : meetings){
            map.put(meet[0],map.getOrDefault(meet[0],0)+1);
            map.put(meet[1],map.getOrDefault(meet[1],0)-1);
        }
        count+=(map.firstKey()-1);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(sum==0 && prev!=-1) count+=(entry.getKey()-prev-1);
            prev=entry.getKey();
            sum+=entry.getValue();
        }
        count+=(days-prev);
        return count;
    }
}