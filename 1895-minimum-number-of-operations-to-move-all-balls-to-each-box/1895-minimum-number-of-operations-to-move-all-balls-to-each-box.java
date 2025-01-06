class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length(),ones=0;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                res[0]+=i;
                ones++;
            }
        }
        if(ones==0) return res;
        int left=boxes.charAt(0)=='1'?1:0,right=ones-left;
        for(int i=1;i<n;i++){
            res[i]=res[i-1]+left-right;
            if(boxes.charAt(i)=='1'){
                left++;
                if(right>0) right--;
            }
        }
        return res;
    }
}