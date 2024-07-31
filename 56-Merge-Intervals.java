class Solution {
    public int[][] merge(int[][] a) {
        Arrays.sort(a,Comparator.comparingInt(o->o[0]));
        int n = a.length;
        int i=0;
        while(i<n-1){
            if(a[i][1]<a[i+1][0]){
                i++;
            }else if(a[i][1]>=a[i+1][0]){
                if(a[i][1]>=a[i+1][1]){
                    a[i+1][0]=a[i][0];
                    a[i+1][1]=a[i][1];
                    a[i][0]=-1;
                    a[i][1]=-1;
                    i++;
                }else{
                    a[i+1][0]=a[i][0];
                    a[i][0]=-1;
                    a[i][1]=-1;
                    i++;
                }
            }
        }
        int index=0;
        for(int j=0;j<n;j++){
            if(a[j][0]!=-1){
                index++;
            }
        }
        int[][] res = new int[index][2];
        i=0;
        for(int j=0;j<n;j++){
            if(a[j][0]!=-1){
                res[i][0]=a[j][0];
                res[i][1]=a[j][1];
                i++;
            }
        }
        return res;
    }
}