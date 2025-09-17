class FoodRatings {
    Map<String,TreeSet<Tuple>> map;
    Map<String,Tuple> tuple;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.map = new HashMap<>();
        this.tuple = new HashMap<>();
        int n = foods.length;
        for(int i=0;i<n;i++){
            Tuple p = new Tuple(foods[i],ratings[i],cuisines[i]);
            tuple.put(foods[i],p);
            map.computeIfAbsent(cuisines[i],k->new TreeSet<>((a,b)->{
                if(a.rating==b.rating) return a.food.compareTo(b.food);
                return b.rating - a.rating;
            })).add(p);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Tuple p = tuple.get(food);
        map.get(p.cuisine).remove(p);
        p.rating = newRating;
        map.get(p.cuisine).add(p);
    }
    
    public String highestRated(String cuisine) {
        return map.get(cuisine).first().food;
    }
}

class Tuple{
    String food,cuisine;
    int rating;
    public Tuple(String _food, int _rating, String _cuisine){
        food = _food;
        cuisine = _cuisine;
        rating = _rating;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */