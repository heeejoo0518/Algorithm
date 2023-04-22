import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(completion);
        Arrays.sort(participant);
        
        for(int i=0;i<completion.length;i++){
            if(!completion[i].equals(participant[i])) return participant[i];
        }
        return participant[participant.length-1];
    }
}
