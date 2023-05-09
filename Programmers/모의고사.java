import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] check = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] count = new int[3];
        
        for(int i=0;i<answers.length;i++){
            for(int j=0;j<3;j++){
                if(answers[i] == check[j][i%check[j].length]) count[j]++;
            }
        }
        
        int max = Math.max(count[0], Math.max(count[1],count[2]));
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<3;i++) if(max==count[i]) list.add(i+1);
        
        
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++) answer[i] = list.get(i);
        return answer;
    }
}
