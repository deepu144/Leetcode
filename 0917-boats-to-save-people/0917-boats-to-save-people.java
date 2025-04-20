class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length,count=0,left=0,right=n-1;
        Arrays.sort(people);
        while(left<=right){
            if(left==right) return count+1;
            else if(people[left]+people[right]<=limit){
                left++;
                right--;
            }
            else if(people[right]<=limit) right--;
            else if(people[left]<=limit) left++;
            count++;
        }
        return count;
    }
}