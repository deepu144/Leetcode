class Solution {
    public int minChanges(int n, int k) {
        String as = Integer.toString(n,2);
        String bb = Integer.toString(k,2);
        char[] a = as.toCharArray();
        char[] b = bb.toCharArray();
        int count=0,j=b.length-1;
        if(b.length>a.length){
            return -1;
        }
        for(int i=a.length-1;i>=0;i--){
            if(j<0) break;

            if(j>-1 && b[j]=='0' && a[i]=='1'){
                count++;
            }else if(j>-1 && b[j]=='1' && a[i]=='0') return -1;
            j--;
        }
        for(int i=0;i<a.length-b.length;i++){
            if(a[i]=='1') count++;
        }
        return count;
    }
}