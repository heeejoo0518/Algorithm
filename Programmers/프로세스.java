import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int len = priorities.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int p:priorities) pq.offer(p);
        
        int max;
        int idx = -1;
        for(int cnt = 1;!pq.isEmpty();cnt++){
            max = pq.poll();
 
            for(int i=(idx+1)%len;i!=idx;i=(i+1)%len){
                if(priorities[i]==max){
                    idx = i;
                    break;
                }
            }
            if(idx==location) return cnt;
            
        }
        
        return -1;
    }
}
