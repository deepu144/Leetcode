class Solution {
    public int[][] merge(int[][] a) {
        Arrays.sort(a,(c,b)->c[0]-b[0]);
        int j=0;
        for(int[] arr : a){
            if(a[j][1]>=arr[0]) a[j][1]=Math.max(a[j][1],arr[1]);
            else{
                j++;
                a[j]=arr;
            }
        }
        return Arrays.copyOfRange(a,0,j+1);
    }
}