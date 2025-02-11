class LockingTree {
    int[] parent;
    int[] lock;
    List<Integer>[] adj;
    public LockingTree(int[] parent) {
        int n=parent.length;
        this.parent=parent;
        this.lock=new int[n];
        adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int i=1;i<n;i++) adj[parent[i]].add(i);
    }
    
    public boolean lock(int num, int user) {
        if(lock[num]!=0) return false;
        lock[num]=user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(lock[num]!=user) return false;
        lock[num]=0;
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        if(lock[num]!=0) return false;
        if(!hasLockedDescendant(num) || lockedAncestor(num)) return false; 
        unlockAllDescendant(num);
        lock[num]=user;
        return true;
    }

    public void unlockAllDescendant(int num){
        Queue<Integer> q=new LinkedList<>();
        q.offer(num);
        while(!q.isEmpty()){
            int p=q.poll();
            if(lock[p]!=0) lock[p]=0;
            for(int node : adj[p]) q.offer(node);
        }
    }

    public boolean lockedAncestor(int num){
        int par=parent[num];
        while(par!=-1){
            if(lock[par]!=0) return true;
            par=parent[par];
        }
        return false;
    }

    public boolean hasLockedDescendant(int num){
        Queue<Integer> q=new LinkedList<>();
        q.offer(num);
        while(!q.isEmpty()){
            int p=q.poll();
            for(int node : adj[p]){
                if(lock[node]!=0) return true;
                q.offer(node);
            }
        }
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */