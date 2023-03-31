import java.io.*;
import java.util.*;

public class BOJ_2167_2차원배열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] sum = new int[N+1][M+1];

		//입력 및 합 구하기
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(in.readLine());
			for(int j=1;j<=M;j++){
				sum[i][j] = Integer.parseInt(st.nextToken()) + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
			}
		}

		//계산
		int K = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		int i,j,x,y;
		for(int k=0;k<K;k++){
			st = new StringTokenizer(in.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			sb.append(sum[x][y]-sum[x][j-1]-sum[i-1][y]+sum[i-1][j-1]).append('\n');
		}

		System.out.print(sb);
	}
}
