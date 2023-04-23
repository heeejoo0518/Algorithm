import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //장르별 재생수 map에 저장
        Map<String, Integer> map = new TreeMap<>();
        for(int i=0;i<genres.length;i++){
            map.put(genres[i], map.getOrDefault(genres[i],0)+plays[i]);
        }
        
        //pq이용 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>(
            (o1,o2)->{
                String g1 = genres[o1];
                String g2 = genres[o2];
                if(!g1.equals(g2)) return map.get(g2)-map.get(g1);
                if(plays[o1] != plays[o2]) return plays[o2]-plays[o1];
                return o1-o2;
            }
        );
        
        for(int i=0;i<plays.length;i++){
            queue.offer(i);
        }
        

        //같은 장르 최대 2개씩 answerList에 저장
        List<Integer> answerList = new ArrayList<>();
        String prev = "."; int count = 0, now;
        while(!queue.isEmpty()){
            now = queue.poll();
            if(prev.equals(genres[now])) count++;
            else count = 0;
            
            if(count<2){
                answerList.add(now);
            }
            
            prev = genres[now];
            
        }
        
        //answerList -> int[] answer
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
