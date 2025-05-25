class Solution {
    public int longestPalindrome(String[] words) {
        int n=words.length,res=0;
        boolean hasSinglePair=false;
        HashMap<String,Integer> map=new HashMap<>();
        Set<String> set=new HashSet<>();
        for(String s : words) map.put(s,map.getOrDefault(s,0)+1);
        for(String key : map.keySet()){
            boolean same = key.charAt(0) == key.charAt(1);
            if(!set.add(key)) continue;
            int revCount = 0 , pair = 0;
            if(same) pair = map.get(key);
            else{
                String rev = key.charAt(1)+""+key.charAt(0);
                revCount = map.getOrDefault(rev,-1);
                if(revCount != -1 && set.add(rev)) pair = Math.min(map.get(key),revCount);
                pair += pair;
            }
            if(pair > 1 && (pair & 1) == 1){
                if(same) hasSinglePair=true;
                pair-=1;
            }
            if(pair==1) hasSinglePair=true;
            else res += pair * 2 ;            
        }
        if(hasSinglePair) res+=2;
        return res;
    }
}