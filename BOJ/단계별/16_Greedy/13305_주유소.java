import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		int[] roads = new int[n];
		int[] oils = new int[n];
		
		StringTokenizer st=  new StringTokenizer(br.readLine()," ");
		for(int i=1;i<n;i++) {
			roads[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			oils[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		long min_price = Long.MAX_VALUE;
		long cost = 0;
		for(int i=0;i<n-1;i++) {
			if(min_price>oils[i]) min_price = oils[i];
			cost += min_price * roads[i+1];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(cost));
		
		bw.flush();
		bw.close();
	}
}