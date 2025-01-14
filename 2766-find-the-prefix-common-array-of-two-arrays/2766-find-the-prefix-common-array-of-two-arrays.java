class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length,prefix=0;
        boolean[] hash=new boolean[51];
        for(int i=0;i<n;i++){
            if(hash[A[i]]) prefix++;
            else hash[A[i]]=true;
            if(hash[B[i]]) prefix++;
            else hash[B[i]]=true;
            A[i]=prefix;
        }
        return A;
    }
}