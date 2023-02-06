import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int MOD = 1000000007;
        P %= MOD;

        long answer = K;
        for(int i=0;i<N;i++){
            answer = (answer*P)%MOD;
        }

        System.out.println(answer);
    }
}