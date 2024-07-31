class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) map.put(n,map.getOrDefault(n,0)+1);
        List<Pair<Integer,Integer>> pq = new ArrayList<>();
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            pq.add(new Pair<>(m.getKey(),m.getValue()));
        }
        Collections.sort(pq,(a,b)->b.getValue()-a.getValue());
        List<Integer> li = new ArrayList<>();
        for(Pair<Integer,Integer> p : pq){
            if(k==0) break;
            li.add(p.getKey());
            k--;
        }
        return li.stream().mapToInt(i->i).toArray();
    }
}