class Solution {
    public long repairCars(int[] ranks, int cars) {
        long st=0,end=1L*cars*cars;
        int min=ranks[0];
        for(int i : ranks) min=Math.min(min,i);
        end*=min;
        while(st<end){
            long mid=st+(end-st)/2;
            if(check(ranks,cars,mid)) end=mid;
            else st=mid+1;
        }
        return st;
    }
    public boolean check(int[] ranks,int cars,long time){
        long repairedCars=0;
        for(int i : ranks){
            repairedCars+=Math.sqrt(time/i);
            if(repairedCars>=cars) return true;
        }
        return false;
    }
}