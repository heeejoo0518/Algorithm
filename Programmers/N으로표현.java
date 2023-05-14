	import java.util.*;
 
class Solution {
    int[] dp, NN;
    int len;
    public int solution(int N, int number) {
        len = number*N;
        dp = new int[len+1];
        Arrays.fill(dp,9);
        
        NN = new int[9];
        for(int i=N, cnt = 1;cnt<9;i=i*10+N, cnt++) NN[cnt] = i;
        
        dfs(N,1);
        
        if(dp[number]>8) return -1;
        return dp[number];
    }
    
    public void dfs(int n, int cnt){
        if(n<0 || n>len || dp[n]<=cnt) return;        
        dp[n] = cnt;
        
        for(int i=1;i<9;i++){
        if(n==NN[i] && i<8) dfs(NN[i+1], cnt+1); 
            dfs(n*NN[i], cnt+i);
            dfs(n+NN[i], cnt+i);
            if(n>=NN[i]) dfs(n/NN[i], cnt+i);
            dfs(n-NN[i], cnt+i);
            if(n!=0) {
                dfs(NN[i]/n, cnt+i);
                dfs(NN[i]-n, cnt+i);
            }    
        }
    }
    
}
