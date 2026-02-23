class Solution {
    int[] parent;
    int[] size;
    public void init(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i; // initially all will parent of itself
            size[i] = 1; // and their group size will be 1
        }
    }
    public int findParent(int x){
        if(parent[x]==x){ // if itself a parent
            return x; // return it
        }
        return parent[x] = findParent(parent[x]); // find super parent of x (parent[x])
    }
    public void union(int a, int b){
        int parentA = findParent(a); // ultimate parent of a
        int parentB = findParent(b); // ultimate parent of b
        if(size[parentA]>=size[parentB]){ // merge other with the group that is larger
            parent[parentB] = parentA; // change parent
            size[parentA] += size[parentB]; // update size of main group
        }else{
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        }
    }
    public int findCircleNum(int[][] isConnected) {
        // Using DSU
        int n = isConnected.length;
        init(n);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i!=j && isConnected[i][j]==1){
                    // merge them ig they are connected
                    union(i, j);
                }
            }
        }

        int count = 0;
        for(int i=0; i<n; i++){
            // count total groups
            if(parent[i]==i) count++;
        }

        return count;
    }
}