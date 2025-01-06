class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                int j=i-1,sum=1;
                while(j>=0) res[j--]+=sum++;
                j=i+1;
                sum=1;
                while(j<n) res[j++]+=sum++;
            }
        }
        return res;
    }
}