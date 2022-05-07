import java.io.*;
import java.util.*;

public class Main{
	static int[] L;
	static int[] J;
	static int[] dp = new int[100]; //99까지 가능
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());

		L = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		J = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();

		for(int i=0;i<n;i++) {
			int health = L[i];
			int joy = J[i];
			for(int j=99;j>=health;j--) {
				dp[j] = Math.max(dp[j], dp[j-health]+joy);
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(dp[99]));
		bw.flush();
		bw.close();
	}
}