class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int max=0,res=0;
        for(List<Integer> li : nums){
            for(int i : li){
                max=Math.max(max,i);
            }
        }
        int[] sweep=new int[max+2];
        for(List<Integer> li : nums){
            sweep[li.get(0)]++;
            sweep[li.get(1)+1]--;
        }
        if(sweep[0]!=0) res++;
        for(int i=1;i<max+2;i++){
            sweep[i]+=sweep[i-1];
            if(sweep[i]!=0) res++;
        }
        return res;
    }
}