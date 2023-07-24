import java.io.*;
import java.util.*;

public class BOJ_2166_다각형의면적 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());

		long[][] coordinate = new long[N+1][2];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			coordinate[i][0] = Integer.parseInt(st.nextToken());
			coordinate[i][1] = Integer.parseInt(st.nextToken());
		}
		coordinate[N] = coordinate[0];

		long area = 0;
		for(int i=0;i<N;i++){
			area += coordinate[i][0]*coordinate[i+1][1];
			area -= coordinate[i+1][0]*coordinate[i][1];
		}

		System.out.printf("%.1f",Math.abs(area)*0.5);
	}
}
