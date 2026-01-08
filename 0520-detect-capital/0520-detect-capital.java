class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        char[] arr = word.toCharArray();
        return isAllCaps(arr) || isAllSmall(arr,n,0) || isFirstOnlyCaps(arr,n);
    }
    public boolean isAllCaps(char[] arr){
        for(char ch : arr) if(Character.isLowerCase(ch)) return false;
        return true;
    }
    public boolean isAllSmall(char[] arr,int n,int i){
        for(int j=i;j<n;j++) if(Character.isUpperCase(arr[j])) return false;
        return true;
    }
    public boolean isFirstOnlyCaps(char[] arr,int n){
        if(!Character.isUpperCase(arr[0])) return false;
        return isAllSmall(arr,n,1);
    }
}