class Solution {
    public String numberToWords(int num) {
        int[] digits={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,1000,1000000,1000000000};
        String[] words={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety","One Hundred","One Thousand","One Million","One Billion"};
        int index=Arrays.binarySearch(digits,num);
        if(index>=0) return words[index];
        int len=String.valueOf(num).length(),n=num,par=0,temp=0,f=1,j=0,size=(int)Math.ceilDiv(len,3);
        int[] split=new int[size];
        while(n>0){
            if(par==3){
                par=0;
                split[j++]=temp;
                temp=0;
                f=1;
            }
            temp=(n%10)*f+temp;
            n/=10;
            f*=10;
            par++;
        }
        if(j<len){
            split[j++]=temp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=size-1;i>=0;i--){
            if(split[i]==0) continue;
            String s=generate(split[i],digits,words);
            if(i==3) sb.append(s+" Billion ");
            else if(i==2) sb.append(s+" Million ");
            else if(i==1) sb.append(s+" Thousand ");
            else sb.append(s);
        }
        return sb.toString().trim();
    }
    public String generate(int num,int[] digits,String[] words){
        if(num==0) return "";
        int ind=Arrays.binarySearch(digits,num);
        if(ind>=0) return words[ind];
        List<Integer> li=new ArrayList<>();
        int f=1,temp=0;
        StringBuilder sb = new StringBuilder();
        while(num>0){
            temp=(num%10)*f;
            li.add(temp);
            f*=10;
            num/=10;
        }
        int size=li.size(),i=0;
        while(i<size){
            int p=li.get(i);
            if(p==0){
                i++;
                continue;
            }
            if(i+1<size){
                int s=li.get(i)+li.get(i+1);
                int index=Arrays.binarySearch(digits,s);
                if(index>0){
                    sb.insert(0,words[index]+" ");
                    i+=2;
                    continue;
                } 
            }
            if(p>=100){
                int q=p/100;
                int index=Arrays.binarySearch(digits,q);
                sb.insert(0,words[index]+" Hundred ");
            }else{
                int index=Arrays.binarySearch(digits,p);
                sb.insert(0,words[index]+" ");
            }
            i++;
        }
        return sb.toString().trim();
    }
}