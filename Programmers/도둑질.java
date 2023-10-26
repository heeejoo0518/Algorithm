import java.util.*;

class 도둑질 {
    public int solution(int[] money) {
        int len = money.length;
        
        int[] dp = new int[len];
        dp[0] = money[0];
        dp[1] = Math.max(money[0],money[1]);
        for(int i=2;i<len-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+money[i]);
        }
        
        int answer = dp[len-2];
        
        dp[0] = 0;
        dp[1] = money[1];
        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+money[i]);
        }
        
        if(answer > dp[len-1]) return answer;
        else return dp[len-1];
    }
}
