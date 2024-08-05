class Solution {
    public String kthDistinct(String[] arr, int k) {
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        for(String s : arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int i=0;
        for(Map.Entry<String,Integer> li : map.entrySet()){
            if(li.getValue()>1){
                continue;
            }
            i++;
            if(i==k){
                return li.getKey();
            }
        }
        return "";
    }
}