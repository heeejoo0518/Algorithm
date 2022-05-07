import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4153_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==0 && b==0 && c==0) break;

            boolean result;
            if(a>b && a>c) result = (a*a==b*b+c*c);
            else if(b>a && b>c) result = (b*b==a*a+c*c);
            else result = (c*c==a*a+b*b);


            if(result) sb.append("right\n");
            else sb.append("wrong\n");
        }

        System.out.print(sb);

    }
}
