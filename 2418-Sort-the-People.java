class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Pair[] p = new Pair[n];
        for(int i =0;i<n;i++){
            p[i]=new Pair(names[i],heights[i]);
        }
        Arrays.sort(p,(a,b)->b.height-a.height);
        String[] s = new String[n];
        for(int i=0;i<n;i++){
            s[i]=p[i].name;
        }
        return s;
    }
}

class Pair{
    String name;
    int height;
    public Pair(String name,int height){
        this.name = name;
        this.height = height;
    }
}