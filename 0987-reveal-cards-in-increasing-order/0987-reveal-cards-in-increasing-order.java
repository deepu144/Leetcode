class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length,j=0,noOfNotAdded=n,k=0;
        if(n<3) return deck;
        int[] res=new int[n];
        Arrays.sort(deck);
        for(int i=0;i<n;i+=2){
            res[i]=deck[j++];
            noOfNotAdded--;
        }
        if(noOfNotAdded==1){
            for(int i=0;i<n;i++){
                if(res[i]==0){
                    res[i]=deck[j++];
                    return res;
                }
            }
        }
        boolean[] oddPos=new boolean[n/2];
        if(res[n-1]!=0) k++;
        oddPos[k]=true;
        res[k*2+1]=deck[j++];
        noOfNotAdded--;
        while(noOfNotAdded!=1){
            boolean f=false;
            while(true){
                k++;
                k%=(n/2);
                if(!oddPos[k]){
                    if(!f) f=true;
                    else break;
                }
            }
            res[k*2+1]=deck[j++];
            oddPos[k]=true;
            noOfNotAdded--;
        }
        for(int i=0;i<n/2;i++){
            if(!oddPos[i]){
                res[i*2+1]=deck[j++];
                break;
            }
        }
        return res;
    }
}