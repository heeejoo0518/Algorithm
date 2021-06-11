import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		int[] times = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();

		Arrays.sort(times);
		
		int total = 0;
		for(int i=0;i<n;i++) {
			total += times[i]*(n-i);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(total));
		
		bw.flush();
		bw.close();
	}
}