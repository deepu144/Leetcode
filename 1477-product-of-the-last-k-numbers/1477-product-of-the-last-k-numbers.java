class ProductOfNumbers {
    List<Integer> arr;
    List<Integer> product;
    int lastZeroIndex,curr;
    public ProductOfNumbers() {
        arr=new ArrayList<>();
        product=new ArrayList<>();
        // product.add(1);
        lastZeroIndex=-1;
        curr=1;
    }
    
    public void add(int num){
        curr*=num; 
        arr.add(num);
        product.add(curr);
        if(curr==0){
            curr=1;
            lastZeroIndex=arr.size()-1;
        }
    }
    
    public int getProduct(int k){
        int size=product.size();
        if(size-k<=lastZeroIndex) return 0;
        if(size-k-1<0) return product.getLast();
        int t=product.get(size-k-1);
        return t==0?product.getLast():(product.getLast()/t);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */