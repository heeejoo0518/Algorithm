import java.io.*;
import java.util.*;

public class Main{
	static final int MOD = 1000000007;
	static final long[][] matrix = new long[][] {{1,1},{1,0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long n = Long.parseLong(br.readLine());
		br.close();
		
		bw.write(String.valueOf(fibonacci(n)));
		bw.flush();
		bw.close();
	}
	
	public static long fibonacci(long n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return squareA(n-1)[0][0]%MOD;
	}
	
	public static long[][] squareA(long b) {
		long[][] result = new long[2][2];
		
		if(b==0) return result;
		if(b==1) return matrix;
		
		result = squareA(b/2);
		
		if(b%2!=0) result = multiply(result, multiply(result, matrix));
		else result = multiply(result,result);
		
		return result;
	}
	
	public static long[][] multiply(long[][] a, long[][] b){
		long[][] ans = new long[2][2];
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					ans[i][j] += (a[i][k]*b[k][j])%MOD;
				}
				ans[i][j]%=MOD;
			}
		}
		
		return ans;
		
	}
}