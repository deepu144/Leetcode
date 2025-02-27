class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length,max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++) map.put(arr[i],i);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a=arr[i],b=arr[j],c=a+b,count=2;
                boolean f=false;
                while(map.containsKey(c)){
                    a=b;
                    b=c;
                    c=a+b;
                    count++;
                    f=true;
                }
                if(f) max=Math.max(max,count);
            }
        }
        return max;
    }
}