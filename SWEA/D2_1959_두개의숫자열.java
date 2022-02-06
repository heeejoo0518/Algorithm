import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D2_1959_두개의숫자열  {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++){
            sb.append("#").append(tc).append(" ");

            //입력
            st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(in.readLine());
            int[] A = new int[N];
            for(int i=0;i<N;i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(in.readLine());
            int[] B = new int[M];
            for(int i=0;i<M;i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            //M, N 비교해서 다시 저장
            int[] large = N>=M? A:B;
            int[] small = N>=M? B:A;

            //탐색
            int max = Integer.MIN_VALUE;
            for(int i=0;i<=large.length-small.length;i++){
                int tmp = 0;
                for(int j=0;j<small.length;j++){
                    tmp += large[i+j]*small[j];
                }
                if(max<tmp) max = tmp;
            }

            //출력
            sb.append(max).append("\n");
        }

        //최종출력
        System.out.print(sb);
    }
}
