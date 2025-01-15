class Solution {
    final int N=9;
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[i][j]!='.' && !set.add(board[i][j]-'0')) return false;
            }
            set.clear();
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(board[j][i]!='.' && !set.add(board[j][i]-'0')) return false;
            }
            set.clear();
        }
        for(int i=0;i<N;i+=3){
            for(int j=0;j<N;j+=3){
                for(int k=i;k<i+3;k++){
                    for(int l=j;l<j+3;l++){
                        if(board[k][l]!='.' && !set.add(board[k][l]-'0')) return false;
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}