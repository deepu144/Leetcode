class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long ans=0;
        int n=skill.length,a=0,b=n-1,prev=skill[a]+skill[b];
        while(a<b){
            if(skill[a]+skill[b]!=prev) return -1;
            ans+=((long)skill[a++]*skill[b--]);
        }
        return ans;
    }
}