import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4948_베르트랑공준 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //false 소수, true 소수아님
        //123456*2 + 1
        boolean[] primeArr = new boolean[246913];

        StringBuilder sb = new StringBuilder();
        while(true){
            int n = Integer.parseInt(in.readLine());
            if(n==0) break;

            int count = 0;
            int nn = n<<1;

          //소수라면 continue, num이 n을 넘어야 카운트, num*2부터 돌면서 소수체크하고 저장
            for(int num=2;num<=nn;num++){
                if(primeArr[num]) continue;

                if(num>n) count++;

                for(int i=num<<1;i<=nn;i+=num){
                    primeArr[i] = true;
                }
            }
            sb.append(count).append("\n");

        }

        System.out.print(sb);
    }
}
