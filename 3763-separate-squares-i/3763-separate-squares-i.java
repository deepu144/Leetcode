class Solution {
    public double separateSquares(int[][] squares) {
        double yMin=0,yMax = 0,ans=0.0;
        for (int[] square : squares) {
            yMax=Math.max(yMax, square[1]+square[2]);
            yMin=Math.min(yMin,square[1]);
        }
        double precision = 1e-5;
        while(yMax-yMin>precision){
            double mid=(yMin+yMax)/2.0;
            double above=0.0,below=0.0;
            for(int[] square : squares){
                int x=square[0],y=square[1],len=square[2];
                if(mid<=y){
                    above+=((double)len*len);
                }else if(mid>=y+len){
                    below+=((double)len*len);
                }else{
                    double aa=(y+len-mid)*len;
                    double bb=(mid-y)*len;
                    above+=aa;
                    below+=bb;
                }
            }
            if(above<=below){
                ans=mid;
                yMax=mid;
            }else if(below<above){
                yMin=mid;
            }
        }
        return ans;
    }
}