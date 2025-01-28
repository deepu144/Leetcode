class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n=recipes.length;
        List<String> result=new ArrayList<>();
        Set<String> set=new HashSet<>();
        HashMap<String,List<String>> adj=new HashMap<>();
        HashMap<String,Integer> inDegree=new HashMap<>();
        for(String supply : supplies) inDegree.put(supply,0);
        for(int i=0;i<n;i++){
            List<String> ingredientList=ingredients.get(i);
            set.add(recipes[i]);
            for(String ingredient : ingredientList){
                if(!adj.containsKey(ingredient)) adj.put(ingredient,new ArrayList<>());
                adj.get(ingredient).add(recipes[i]);
                inDegree.put(recipes[i],inDegree.getOrDefault(recipes[i],0)+1);
            }
        }
        Queue<String> q=new LinkedList<>();
        for(String supply : inDegree.keySet()) if(inDegree.get(supply)==0) q.offer(supply);
        while(!q.isEmpty()){
            String node = q.poll();
            if(set.contains(node)) result.add(node);
            for(String ingredient : adj.getOrDefault(node,new ArrayList<>())){
                inDegree.put(ingredient,inDegree.get(ingredient)-1);
                if(inDegree.get(ingredient)==0) q.offer(ingredient);
            }
        }
        return result;
    }
}