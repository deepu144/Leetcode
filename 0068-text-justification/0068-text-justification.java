class Solution {
    public List<String> fullJustify(String[] words, int width) {
        int n=words.length,i=0;
        List<String> res=new ArrayList<>();
        while(i<n){
            char[] ch=new char[width];
            Arrays.fill(ch,' ');
            int space=-1,len=0,j=i;
            boolean isLast=false;
            while(width>(space+len)){
                if(j==n){
                    j--;
                    isLast=true;
                    break;
                }
                space++;
                len+=words[j].length();
                if(len+space==width) break;
                if(len+space>width){
                    len-=words[j].length();
                    space--;
                    j--;
                    break;
                }
                j++;
            }
            int word=j-i+1,totSpaces=width-(space+len),additional=0,single=1,p=0;
            if(space!=0 && totSpaces%space==0) single+=totSpaces/space;
            else{
                if(totSpaces>space && space!=0){
                    single+=totSpaces/space;
                    additional=totSpaces%space;
                }else if(totSpaces<space) additional=totSpaces;
            }
            if(isLast){
                single=1;
                additional=0;
            }
            while(i<=j){
                String s=words[i];
                for(int k=0;k<s.length() && p<width;k++) ch[p++]=s.charAt(k);
                for(int k=0;k<single && p<width;k++) ch[p++]=' ';
                if(additional>0 && p<width){
                    ch[p++]=' ';
                    additional--;
                }
                i++;
            }
            res.add(new String(ch));
        }
        return res;
    }
}