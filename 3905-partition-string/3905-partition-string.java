class Solution {
    public List<String> partitionString(String s) {
        int n=s.length(),i=0;
        Set<String> set=new HashSet<>();
        List<String> res=new ArrayList<>();
        String curr="";
        while(i<n){
            curr+=""+s.charAt(i);
            if(set.add(curr)){
                res.add(curr);
                curr="";
            }
            i++;
        }
        return res;
    }
}