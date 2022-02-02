import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        in.close();

        StringBuilder sb = new StringBuilder();

        for(int num=M;num<=N;num++){
            if(num==1) continue;

            boolean isPrime = true;
            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) sb.append(num).append("\n");
        }

        System.out.print(sb.toString());
    }

}
