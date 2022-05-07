import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        StringTokenizer st= new StringTokenizer(in.readLine());
        in.close();

        int count = 0;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) continue;

            boolean isPrime = true;
            for(int i=2;i<num;i++){
                if(num%i==0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) count++;
        }

        System.out.println(count);
    }
}
