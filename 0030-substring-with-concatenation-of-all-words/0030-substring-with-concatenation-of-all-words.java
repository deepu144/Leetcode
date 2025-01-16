class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n=words.length,m=s.length();
        List<Integer> res=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(String a:words) map.put(a,map.getOrDefault(a,0)+1);
        int wordLen=words[0].length(),windowLen=n*wordLen;
        for(int i=0;i<wordLen;i++){
            Map<String,Integer> freq=new HashMap<>();
            int count=0,left=i;
            for(int j=i;j<=m-wordLen;j+=wordLen){
                String a=s.substring(j,j+wordLen);
                if(map.containsKey(a)){
                    freq.put(a,freq.getOrDefault(a,0)+1);
                    count++;
                    while(freq.get(a)>map.get(a)){
                        String leftWord=s.substring(left,left+wordLen);
                        freq.put(leftWord,freq.get(leftWord)-1);
                        left+=wordLen;
                        count--;
                    }
                    if(count==n) res.add(left);
                }else{
                    freq.clear();
                    left=j+wordLen;
                    count=0;
                }
            }
        }
        return res;
    }
}