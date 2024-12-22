class Solution {
    final String COMMA=",";
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]<heights[i]) arr[st.pop()]=i;
            st.push(i);
        }
        while(!st.isEmpty()){
            int ind=st.pop();
            arr[ind]=ind;
        }
        int m=queries.length;
        int[] res=new int[m];
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<m;i++){
            int[] a=queries[i];
            if(a[0]>a[1]){
                int t=a[0];
                a[0]=a[1];
                a[1]=t;
            }
            String s=a[0]+COMMA+a[1];
            if(map.containsKey(s)){
                res[i]=map.get(s);
                continue;
            }
            if(a[0]==a[1]) res[i]=a[0];
            else if(heights[a[0]]<heights[a[1]]) res[i]=a[1];
            else if(heights[a[0]]>heights[a[1]]){
                if(heights[a[0]]<heights[arr[a[1]]]) res[i]=arr[a[1]];
                else if(arr[a[0]]>a[1]) res[i]=arr[a[0]];
                else{
                    int j=a[1]+1;
                    boolean noMeet=true;
                    while(j<n){
                        if(heights[j]>heights[a[0]]){
                            res[i]=j;
                            noMeet=false;
                            break;
                        }
                        j++;
                    }
                    if(noMeet) res[i]=-1;
                }
            }else res[i]=arr[a[1]]==a[1]?-1:arr[a[1]];
            map.put(s,res[i]);
        }
        return res;
    }
}