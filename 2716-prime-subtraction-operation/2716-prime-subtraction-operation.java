class Solution {
    static List<Integer> primes=new ArrayList<>();
    static boolean flag=true;
    public boolean primeSubOperation(int[] nums) {
        if(flag){
            seiveOfEratosthenes();
            flag=false;
        }
        int n=nums.length,size=primes.size();
        for(int i=n-2;i>=0;i--){
            if(nums[i]>=nums[i+1]){
                int res = binarySearch(nums[i],nums[i+1],size);
                if(res==-1) return false;
                nums[i]=res;
            }
        }
        return true;
    }
    public int binarySearch(int value,int next,int n){
        int st=0,end=n-1,ans=-1;
        while(st<=end){
            int idx = st+(end-st)/2;
            int midValue = primes.get(idx);
            if(value-midValue < next){
                ans=idx;
                end=idx-1;
            }else st=idx+1;
        }
        if(ans==-1 || value-primes.get(ans)<=0) return -1;
        return value-primes.get(ans);
    }
    public void seiveOfEratosthenes(){
        boolean[] arr=new boolean[1001];
        arr[1]=true;
        for(int i=2;i<=31;i++){
            if(!arr[i]) for(int j=i*i;j<=1000;j+=i) arr[j]=true;
        }
        for(int i=2;i<=1000;i++) if(!arr[i]) primes.add(i);
    }
}