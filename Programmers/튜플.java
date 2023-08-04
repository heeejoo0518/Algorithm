import java.util.*;
 
class 튜플 {
    public int[] solution(String s) {
        int[] count = new int[100_001];
        StringTokenizer st = new StringTokenizer(s, " {},");
        int max = 0;
        while(st.hasMoreTokens()){
            max = Math.max(max,++count[Integer.parseInt(st.nextToken())]);
        }
        
        int[] answer = new int[max];
        for(int i=1;i<100_001;i++){
            if(count[i]==0) continue;
            answer[max-count[i]] = i;
        }
        
        return answer;
    }
}
