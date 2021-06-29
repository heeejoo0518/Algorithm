import java.io.*;
import java.util.*;

public class Main{
	static int[][] A;
	static int[][] B;
	static int[][] result;
	static int N,M,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		A = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine()," ");
		st.nextToken();
		K = Integer.parseInt(st.nextToken());
		
		B = new int[M][K];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<K;j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		result = new int[N][K];
		for(int i=0;i<N;i++) {
			for(int j=0;j<K;j++) {
				int ans = 0;
				for(int k=0;k<M;k++) {
					ans += (A[i][k]*B[k][j]);
				}
				result[i][j] = ans;
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}