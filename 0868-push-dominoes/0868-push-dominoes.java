class Solution {
    public String pushDominoes(String dominoes) {
        StringBuilder sb=new StringBuilder();
        List<Integer> li=new ArrayList<>();
        int n=dominoes.length();
        for(int i=0;i<n;i++) if(dominoes.charAt(i)!='.') li.add(i);
        int size=li.size();
        if(size==0) return dominoes;
        if(!li.isEmpty()){
            int j=li.getFirst();
            char ch=dominoes.charAt(j);
            if(ch=='L') onlyLeft(sb,j+1);
            else{
                for(int i=0;i<j;i++) sb.append('.');
                sb.append('R');
            }
        }
        for(int i=0;i<size-1;i++){
            int currInd=li.get(i),nextInd=li.get(i+1);
            char curr=dominoes.charAt(currInd),next=dominoes.charAt(nextInd);
            if(curr=='L'){
                if(next=='L') onlyLeft(sb,nextInd-currInd);
                else{
                    sb.append(".".repeat(nextInd-currInd-1));
                    sb.append('R');
                }
            }else{
                if(next=='R') onlyRight(sb,nextInd-currInd);
                else rightLeft(sb,nextInd-currInd+1);
            }
        }
        if(!li.isEmpty()){
            int j=li.getLast();
            char ch=dominoes.charAt(j);
            if(ch=='R') onlyRight(sb,n-j-1);
            else sb.append(".".repeat(n-j-1));
        }
        return sb.toString();
    }
    public void onlyLeft(StringBuilder sb,int len){
        for(int i=0;i<len;i++) sb.append('L');
    }
    public void onlyRight(StringBuilder sb,int len){
        for(int i=0;i<len;i++) sb.append('R');
    }
    public void rightLeft(StringBuilder sb,int len){
        int half=len/2;
        if(len%2==1){
            sb.append("R".repeat(half-1));
            sb.append('.');
            sb.append("L".repeat(half));
        }else{
            sb.append("R".repeat(half-1));
            sb.append("L".repeat(half));
        }
    }
}