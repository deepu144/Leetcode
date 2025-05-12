class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> li=new ArrayList<>();
        int[] fre=new int[10];
        for(int a : digits) fre[a]++;
        for(int i=100;i<1000;i+=2) if(canForm(i,fre)) li.add(i);
        return li.stream().mapToInt(Integer::intValue).toArray();
    }
    public boolean canForm(int n,int[] fre){
        int[] hash=new int[10];
        while(n>0){
            hash[n%10]++;
            n/=10;
        }
        for(int i=0;i<10;i++) if(hash[i]>fre[i]) return false;
        return true;
    }
}