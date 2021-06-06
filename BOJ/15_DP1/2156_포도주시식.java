import java.io.*;

public class Main{
	static int[] wine;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());		
		
		wine = new int[n+1];
		dp = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();

		drinkWine(n);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(getMax(n)+"");
		
		bw.flush();
		bw.close();
	}
	
	public static int drinkWine(int n) {
		if(n<1) return 0;
		if(dp[n]!=0) return dp[n];
		
		if(n==1) return dp[1] = wine[1];
		
		drinkWine(n-1);
		
		return dp[n] = Math.max(wine[n-1]+getMax(n-3),getMax(n-2))+wine[n];
	}

	public static int getMax(int n) {
		int max = 0;
		for(int i=1;i<=n;i++) {
			if(max<dp[i]) max = dp[i];
		}
		return max;
	}
	
}