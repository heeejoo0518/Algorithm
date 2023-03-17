import java.util.*;

class Solution {
    public int solution(int N) {
        int answer = 0;

        int tmp = 0;
        boolean one = false;
        while(N>0){
            if(N%2==1){
                one = true;
                answer = Math.max(answer,tmp);
                tmp = 0;
            }else if(one){
                tmp++;
            }
            N/=2;
        }

        return answer;
    }
}
