class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        long num = numerator, den = denominator;
        boolean isPositive = (num>=0 && den >=0) || (num<0 && den<0);
        if(!isPositive){
            num = Math.abs(num);
            den = Math.abs(den);
        }
        long integerPart = num/den;
        int repeatStartsAt = -1, n=0;
        num = num % den;
        if(num == 0) return integerPart==0 ? integerPart+"" : isPositive ? integerPart+"" : "-"+integerPart;
        sb.append(integerPart+".");
        HashMap<Long,Integer> map=new HashMap<>();
        List<Long> decimal=new ArrayList<>();
        num*=10L;
        if(integerPart == 0) {
            while(num < den){
                map.put(num,decimal.size());
                decimal.add(0L);
                num *= 10;
            }
        }
        while(true){
            long rem = num%den, quotient = num/den;
            int idx = map.getOrDefault(rem,-1);
            if(idx != -1 && decimal.get(idx)==quotient){
                repeatStartsAt = idx;
                break;
            }
            decimal.add(quotient);
            if(rem == 0) break;
            map.put(rem,decimal.size()-1);
            rem *= 10;
            num = rem;
            idx = map.getOrDefault(num,-1);
            if(idx != -1 && decimal.get(idx)==quotient){
                repeatStartsAt = idx;
                break;
            }
        }
        n = decimal.size();
        if(repeatStartsAt == -1) repeatStartsAt = n;
        for(int i=0;i<repeatStartsAt;i++) sb.append(decimal.get(i));
        if(repeatStartsAt < n){
            sb.append('(');
            for(int i=repeatStartsAt;i<n;i++) sb.append(decimal.get(i));
            sb.append(')');
        }
        if(!isPositive) sb.insert(0,'-');
        return sb.toString();
    }
}