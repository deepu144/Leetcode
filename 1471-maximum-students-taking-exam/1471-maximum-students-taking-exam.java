class Solution {
    public int maxStudents(char[][] seats) {
        int r=seats.length,c=seats[0].length;
        int[] validSeats=new int[r];
        for(int i=0;i<r;i++){
            int mask=0;
            for(int j=0;j<c;j++){
                if(seats[i][j]=='.') mask|=(1<<j);
            }
            validSeats[i]=mask;
        }
        return helper(validSeats,r,c,0,0,new Integer[r][(1<<c)]);
    }
    public int helper(int[] validSeats,int r,int c,int currRow,int prevMask,Integer[][] dp){
        if(currRow==r) return 0;
        if(dp[currRow][prevMask]!=null) return dp[currRow][prevMask];
        int max=0;
        for(int currMask=0;currMask<(1<<c);currMask++){
            if((currMask & validSeats[currRow]) != currMask) continue;
            if(((currMask>>1) & currMask) != 0) continue;
            if(((currMask<<1) & prevMask) != 0) continue;
            if(((currMask>>1) & prevMask) != 0) continue;
            int seat=Integer.bitCount(currMask);
            max=Math.max(max,seat+helper(validSeats,r,c,currRow+1,currMask,dp));
        }
        return dp[currRow][prevMask]=max;
    }
}