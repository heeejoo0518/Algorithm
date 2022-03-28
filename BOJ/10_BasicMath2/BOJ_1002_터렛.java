import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1002_터렛 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(in.readLine());

        StringBuilder sb = new StringBuilder();
        while(N-->0){
            st = new StringTokenizer(in.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double D = Math.sqrt(Math.pow(Math.abs(x1-x2),2)+Math.pow(Math.abs(y1-y2),2));
            double R = r1+r2;
            if(x1==x2 && y1==y2 && r1==r2) sb.append("-1\n");
            else if(D==R ||D==Math.abs(r1-r2)) sb.append("1\n");
            else if(D>R || D<Math.abs(r1-r2)) sb.append("0\n");
            else sb.append("2\n");

            //동심원인경우 --> 무한대
            //두 점에서 만나는 경우 --> 2개
            //한 점에서 만나는 경우 --> 1개
            //만나지 않는 경우 --> 0개

        }

        System.out.print(sb);

    }
}
