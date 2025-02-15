class Solution {
    public static HashMap<Integer,Integer> map=new HashMap<>();
    public int punishmentNumber(int n) {
        int start=1,res=0;
        boolean f=false;
        for(int key : map.keySet()){
            if(n>=key){
                res=map.get(key);
                start=key;
                f=true;
            }
        }
        if(f) start++;
        for(int i=start;i<=n;i++){
            if(i%9==0 || i%9==1){
                int square=i*i;
                int[] arr=convertToArray(square);
                if(helper(i,arr,0,arr.length,0)){
                    res+=square;
                    map.put(i,res);
                }
            }
        }
        return res;
    }
    public int[] convertToArray(int n){
        int digit=(int)(Math.floor(Math.log10(n)+1));
        int[] arr=new int[digit];
        int k=digit-1;
        while(n>0){
            arr[k--]=n%10;
            n/=10;
        }
        return arr;
    }
    public boolean helper(int target,int[] arr,int ind,int n,int tot){
        if(n==ind) return tot==target;
        int sum=0;
        for(int i=ind;i<n;i++){
            sum=(sum*10)+arr[i];
            if(sum<=target) if(helper(target,arr,i+1,n,tot+sum)) return true;
        }
        return false;
    }
}