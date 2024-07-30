class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> ans = new ArrayList<>();
        plus(digits,digits.length-1,0,1,ans);
        return ans.stream().mapToInt(i->i).toArray();
    }
    public void plus(int[] arr,int n,int carry,int sum,List<Integer> ans){
        if(n==-1){
            if(carry!=0) ans.addFirst(carry);
            return;
        }
        int i=arr[n]+sum+carry;
        if(i<10) ans.addFirst(i);
        else ans.addFirst(i%10);
        carry=0;
        if(i>=10) carry=i/10;
        plus(arr,n-1,carry,0,ans);
    }
}