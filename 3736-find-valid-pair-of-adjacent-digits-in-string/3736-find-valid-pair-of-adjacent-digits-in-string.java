class Solution {
    public String findValidPair(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        for(int i=1;i<n;i++){
            char ch1=s.charAt(i-1);
            char ch2=s.charAt(i);
            if(ch1!=ch2 && map.get(ch1)==(ch1-'0') && map.get(ch2)==(ch2-'0')) return ch1+""+ch2;
        }
        return "";
    }
}