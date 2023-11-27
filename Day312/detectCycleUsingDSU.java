
class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean v[]=new boolean[V];
        int p[]=new int[V];
        for(int i=0;i<V;i++){
            p[i]=i;
        }
        for(int i=0;i<V;i++)
        {
            v[i]=true;
            for(int nbr : adj.get(i)){
                if(v[nbr]==false){
                    int x=parent(i,p);
                    int y=parent(nbr,p);
                    if(x==y){
                        return 1;
                    }
                    else{
                        union(x,y,p);
                    }
                }
            }
        }
        return 0;
    }
    int parent(int x,int p[]){
        if(p[x]==x)
            return x;
        int r=parent(p[x],p);
        p[x]=r;
        return r;
    }
    void union(int x,int y,int p[]){
        p[x]=y;
    }
}