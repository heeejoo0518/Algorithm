import java.io.*;
import java.util.*;

public class Main{
	static int sum[];
	static int sequence[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		sum = new int[n+1];
		sequence = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=n;i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		br.close();
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			sum[i] = Math.max(0, sum[i-1])+sequence[i];
			if(max<sum[i]) max = sum[i];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(max+"");
		
		bw.flush();
		bw.close();
	}
}