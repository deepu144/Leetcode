class Solution {
    public int[] findRightInterval(int[][] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            map.put(arr[i][0],i);
        }
        Arrays.sort(arr,Comparator.comparingInt(a->a[0]));
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[map.get(arr[i][0])]=binarySearch(arr,n,map,arr[i][1]);
        }
        return res;
    }
    public int binarySearch(int[][] arr,int n,Map<Integer,Integer> map,int key){
        if(key>arr[n-1][0]) return -1;
        int s=0,e=n-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(key==arr[mid][0]) return map.get(key);
            else if(arr[mid][0]<key) s=mid+1;
            else e=mid-1;
        }
        return map.get(arr[s][0]);
    }
}