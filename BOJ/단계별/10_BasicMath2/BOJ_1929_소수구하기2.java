import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        in.close();

        boolean[] primeArr = new boolean[N+1];

        StringBuilder sb = new StringBuilder();

        for(int num=2;num<=N;num++){
            if(primeArr[num]) continue;

            if(num>=M) sb.append(num).append("\n");

            //num의 배수=소수가 아님
            for(int i=num<<1;i<=N;i+=num){
                primeArr[i] = true;
            }
        }

        System.out.print(sb);

    }

}
