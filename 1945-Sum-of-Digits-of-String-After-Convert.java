class Solution {
    public int getLucky(String s, int k) {
        int num=0;
        List<Integer> li = new ArrayList<>();
        for(char c : s.toCharArray()) li.add((num*10)+(c-96));
        if(k>=1){
            for(int i : li){
                int t = i;
                while(t>0){
                    num+=t%10;
                    t/=10;
                }
            }
        }
        k--;
        int sum=0;
        while(k!=0){
            sum=0;
            int t=num;
            while(t>0){
                sum+=t%10;
                t/=10;
            }
            k--;
            num=sum;
        }
        return num;
    }
}