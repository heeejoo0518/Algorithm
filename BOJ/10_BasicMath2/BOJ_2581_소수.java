import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2581_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(in.readLine());
        int N = Integer.parseInt(in.readLine());

        int sum = 0;
        int min = -1;
        for (int num = M; num <= N; num++) {
            if (num == 1) continue;

            boolean isPrime = true;

            //half(num/2, (num+1)/2)까지만 비교해도 소수 찾기 가능 (계산 줄이려고 일괄 (num+1)/2로 함)
            //하지만 4ms 차이밖에 안됨(M,N 최대값이 10000이라서 그런거라고 추측)
            for (int i = 2; i <= (num+1)/2; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                sum += num;
                if (min == -1) min = num;
            }
        }

        if(min != -1) {
            System.out.println(sum);
            System.out.println(min);
        }else{
            System.out.println(-1);
        }

    }
}
