class Solution {
    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^0-9A-Za-z]","").toLowerCase();
        return isValid(str);
    }
    public boolean isValid(String str){
        int a = 0;
        int b = str.length()-1;

        while(a<=b){
            if(str.charAt(a)!=str.charAt(b)){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
}