import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n];
		for(int i=0;i<n;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		int[] price = new int[k+1];
		price[0] = 1;

		for(int i=0;i<n;i++) {
			for(int j=1;j<=k;j++) {
				if(j<coins[i]) continue;
				price[j] += price[j-coins[i]];
			}
		}
		
		
		bw.write(String.valueOf(price[k]));
		bw.flush();
		bw.close();
	}
}