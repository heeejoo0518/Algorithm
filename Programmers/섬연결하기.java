import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n+1];
        for(int i=1;i<=n;i++) parent[i] = i;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
        for(int[] cost:costs) queue.offer(cost);
        
        int cost = 0;
        int[] tmp;
        while(!queue.isEmpty()){
            tmp = queue.poll();
            if(union(tmp[0], tmp[1])) cost += tmp[2];
        }
        
        return cost;
    }
    public int find(int a){
        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }
    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa==pb) return false;
        parent[pa] = pb;
        return true;
    }
}
