class Solution {
    public String getHint(String secret, String guess) {
        int[] sec = new int[10];
        int[] guss = new int[10];
        int cow=0,bull=0;
        for(int i=0;i<secret.length();i++){
            char s=secret.charAt(i),g=guess.charAt(i);
            boolean a=true,b=true;
            if(s==g){
                bull++;
                continue;
            }
            if(guss[s-48]>0){
                cow++;
                guss[s-48]--;
                a=false;
            }
            if(sec[g-48]>0){
                cow++;
                sec[g-48]--;
                b=false;
            }
            if(a){
                sec[s-48]++;
            }
            if(b){
                guss[g-48]++;
            }
        }
        return bull+\A\+cow+\B\;
    }
}