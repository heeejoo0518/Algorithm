import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(String[] c:clothes){
            map.put(c[1],map.getOrDefault(c[1],1)+1);
        }
        
        int answer = 1;
        for(int value:map.values()){
            answer *= value;
        }
        
        return answer-1;
    }
}
