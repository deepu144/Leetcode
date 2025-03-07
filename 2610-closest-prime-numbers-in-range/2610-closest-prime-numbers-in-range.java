class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] arr=new boolean[right-left+1];
        int limit=(int)(Math.sqrt(right));
        for(int i=2;i<=limit;i++){
            if(left>=i){
                int rem=left%i,start=(rem==0)?left:left+i-rem;
                while(start<=right){
                    arr[start-left]=true;
                    start+=i;
                }
            }else{
                if(!arr[i-1]){
                    int start=i+i;
                    while(start<=right){
                        arr[start-left]=true;
                        start+=i;
                    }
                }
            }
        }
        if(left==1) arr[0]=true;
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<right-left+1;i++) if(!arr[i]) li.add(i+left);
        if(li.size()<2) return new int[]{-1,-1};
        int min=right+1,num1=-1,num2=-1;
        for(int i=1;i<li.size();i++){
            int a=li.get(i),b=li.get(i-1);
            if(a-b<min){
                min=a-b;
                num1=b;
                num2=a;
            }
        }
        return new int[]{num1,num2};
    }
}