class Solution {
    record Pair(String code,String businessLine){}
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Pair> li=new ArrayList<>();
        int n=code.length;
        for(int i=0;i<n;i++){
            if(isActive[i] && hasCategory(businessLine[i]) && isAlphanumeric(code[i])){
                li.add(new Pair(code[i],businessLine[i]));
            }
        }
        Collections.sort(li,(a,b)->{
            if(a.businessLine.equals(b.businessLine)) return a.code.compareTo(b.code);
            return a.businessLine.compareTo(b.businessLine);
        });
        List<String> res=new ArrayList<>();
        for(Pair p : li) res.add(p.code);
        return res;
    }
    public boolean hasCategory(String s){
        return s.equals("electronics") || s.equals("grocery") || s.equals("pharmacy") ||
                s.equals("restaurant");
    }
    public boolean isAlphanumeric(String s){
        int n=s.length();
        if(n==0) return false;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            boolean isAlphanumeric = Character.isLetter(ch) || Character.isDigit(ch) || ch=='_';
            if(!isAlphanumeric) return false;
        }
        return true;
    }
}