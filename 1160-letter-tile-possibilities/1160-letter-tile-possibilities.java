class Solution {
    public int numTilePossibilities(String tiles) {
        Set<List<Character>> allPermutation=new HashSet<>();
        generate(0,tiles.toCharArray(),tiles.length(),allPermutation);
        Set<List<Character>> res=new HashSet<>();
        for(List<Character> li : allPermutation){
            char[] ch=new char[li.size()];
            for(int i=0;i<li.size();i++) ch[i]=li.get(i);
            subsets(0,ch,li.size(),res,new ArrayList<>());
        }
        return res.size()-1;
    }
    public void subsets(int i,char[] arr,int n,Set<List<Character>> ans,List<Character> subset){
        ans.add(new ArrayList<>(subset));
        for(int j=i;j<n;j++){
            if(i<j && arr[j] == arr[j-1]) continue;
            subset.add(arr[j]);
            subsets(j+1,arr,arr.length,ans,subset);
            subset.remove(subset.size()-1);
        }
    }
    public void generate(int ind,char[] arr,int n,Set<List<Character>> ans){
        if(ind==n){
            List<Character> curr = new ArrayList<>();
            for(char a : arr) curr.add(a);
            ans.add(curr);
            return;
        }
        for(int i=ind;i<n;i++){
            swap(arr,i,ind);
            generate(ind+1,arr,n,ans);
            swap(arr,i,ind);
        }
    }
    public void swap(char[] arr,int i,int j){
        char t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}