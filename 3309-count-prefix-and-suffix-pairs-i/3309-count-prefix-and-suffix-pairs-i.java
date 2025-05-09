class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i],words[j])){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPrefixAndSuffix(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 > len2) return false;
        boolean isPrefix = str2.startsWith(str1);
        boolean isSuffix = str2.endsWith(str1);
        return isPrefix && isSuffix;
    }



}