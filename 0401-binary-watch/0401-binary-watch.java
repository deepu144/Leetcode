class Solution {
    public List<String> readBinaryWatch(int on) {
        int[] time = new int[]{8,4,2,1,32,16,8,4,2,1};
        List<String> ans = new ArrayList<>();
        generate(on,0,time,ans,new ArrayList<>());
        return ans;
    }

    public void generate(int on,int i,int[] time,List<String> ans,List<Integer> ds){
        if(ds.size()==on){
            validate(ans,ds,time);
            return;
        }
        if(i>=time.length) return;
        ds.add(i);
        generate(on,i+1,time,ans,ds);
        ds.removeLast();
        generate(on,i+1,time,ans,ds);
    }

    public void validate(List<String> ans,List<Integer> ds,int[] time){
        int h=0,m=0;
        for(int i : ds){
            if(i<=3) h+=time[i];
            else m+=time[i];
            if(h>=12 || m>=60) return;
        }
        if(h>=12 || m>=60) return;
        String hh=String.valueOf(h);
        String mm=String.valueOf(m);
        if(m<=9) mm=String.valueOf("0"+m);
        ans.add(hh+":"+mm);
    }

}