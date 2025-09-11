class Solution {
    public String sortVowels(String s) {
        int[] arr = new int[126];
        int n=s.length(),k=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(isVowel(ch)) arr[ch]++;
        }
        while(k<126 && arr[k]==0) k++;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                sb.append((char)k);
                arr[k]--;
                while(k<126 && arr[k]==0) k++;
            }else sb.append(ch);
        }
        return sb.toString();
    }
    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}