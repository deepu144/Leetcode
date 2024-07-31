class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for(char c : ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>((a,b) -> {
            return (b.getKey()).compareTo(a.getKey());
        });
        for(Map.Entry<Character,Integer> m : map.entrySet()){
            pq.add(new Pair<>(m.getValue(),m.getKey()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair<Integer,Character> p = pq.poll();
            for(int i=0;i<p.getKey();i++){
                sb.append(p.getValue());
            }
        }
        return sb.toString();
    }
}