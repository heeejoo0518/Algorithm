import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		for(int i=0;i<n;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();

		int ans = 0;
		for(int i=n-1;i>0;i--) {
			ans += (k/coins[i]);
			k %= coins[i];
		}
		ans += k;
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(ans));
		
		bw.flush();
		bw.close();
	}
}