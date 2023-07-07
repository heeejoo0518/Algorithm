import java.io.*;
import java.math.BigInteger;

public class BOJ_10826_피보나치수4 {
	public static void main(String[] args) throws IOException {
		BigInteger[] dp = new BigInteger[10001];
		dp[0] = BigInteger.ZERO;
		dp[1] = dp[2] = BigInteger.ONE;
		for(int i=3;i<10001;i++) dp[i] = dp[i-1].add(dp[i-2]);
		System.out.println(dp[Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())]);
	}
}
