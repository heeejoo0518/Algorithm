import java.io.*;
import java.util.*;

public class Main{
	static int[][] A;
	static int N;
	static final int MOD = 1000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		A = new int[N][N];
		int[][] result = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken())%MOD;
			}
		}
		
		br.close();
		result = squareA(b);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(result[i][j]+" ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static int[][] squareA(long b) {
		int[][] result = new int[N][N];
		
		if(b==0) return result;
		if(b==1) return A;
		
		result = squareA(b/2);
		
		if(b%2!=0) result = multiply(result, multiply(result, A));
		else result = multiply(result,result);
		
		return result;
	}
	
	public static int[][] multiply(int[][] a, int[][] b){
		int[][] ans = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					ans[i][j] += (a[i][k]*b[k][j])%MOD;
				}
				ans[i][j]%=MOD;
			}
		}
		
		return ans;
		
	}
}