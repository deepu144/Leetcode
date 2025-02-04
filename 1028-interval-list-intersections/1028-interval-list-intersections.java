class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m=firstList.length,n=secondList.length,i=0,j=0;
        List<int[]> li=new ArrayList<>();
        while(i<m && j<n){
            if(firstList[i][1]<secondList[j][0]) i++;
            else if(firstList[i][0]>secondList[j][1]) j++;
            else{
                if(firstList[i][0]<=secondList[j][0] && secondList[j][0]<=firstList[i][1]){
                    li.add(new int[]{secondList[j][0],Math.min(firstList[i][1],secondList[j][1])});
                }else if(secondList[j][0]<=firstList[i][0] && firstList[i][0]<=secondList[j][1]){
                    li.add(new int[]{firstList[i][0],Math.min(firstList[i][1],secondList[j][1])});
                }
                if(firstList[i][1]<secondList[j][1]) i++;
                else if(firstList[i][1]>secondList[j][1]) j++;
                else{
                    i++;
                    j++;
                }
            }
        }
        return li.toArray(new int[0][]);
    }
}