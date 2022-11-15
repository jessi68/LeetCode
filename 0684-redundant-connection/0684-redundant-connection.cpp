class Solution {
public:
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        int parent_size = edges.size() + 1;
        parents.resize(parent_size);
        
        for(int i = 0; i <  parent_size; i++) {
            parents[i] = i;
        }
        
        for(auto e: edges)
            if (find(e[0]) == find(e[1])) return e;
            else unionFunc(e[0],e[1]);
        return edges[0];
        
    }
private:
    vector<int> parents;
    int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);   
        }
        return parents[x];
    }
    
    void unionFunc(int x, int y) {
        parents[find(x)] = find(y);
    }
};