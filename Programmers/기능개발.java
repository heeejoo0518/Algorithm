import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int tmp = 1, day = 0, progress,speed;
        for(int i=0;i<progresses.length;i++){
            speed = speeds[i];
            progress = progresses[i] + speed*day;
            
            if(progress >= 100){
                tmp++;
                continue;
            }
            
            list.add(tmp);
            tmp = 1;
            day += (int)Math.ceil((100-progress)/(double)speed);
        }

        list.add(tmp);
        
        int[] answer = new int[list.size()-1];//첫번째 의미없는 1 삭제
        for(int i=1;i<list.size();i++){
            answer[i-1] = list.get(i);
        }
        
        return answer;
    }
}
