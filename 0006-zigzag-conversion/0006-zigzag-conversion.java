class Solution {
    public String convert(String s, int row) {
        if(row==1||s.length()==row) return s;
        List<Character>[] ch=new List[row];
        for(int i=0;i<row;i++) ch[i]=new ArrayList<>();
        int i=0,t=0,n=s.length();
        boolean isDown=true;
        while(i<n){
            if(isDown){
                ch[t].add(s.charAt(i++));
                if(t==row-1){
                    isDown=false;
                    t--;
                    continue;
                }
                t++;
            }else{
                ch[t].add(s.charAt(i++));
                if(t==0){
                    isDown=true;
                    t++;
                    continue;
                }
                t--;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(List<Character> li : ch) for(char c : li) sb.append(c);
        return sb.toString();
    }
}