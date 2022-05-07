import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nArr = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nArr);
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<m;i++) {
			int idx = Arrays.binarySearch(nArr, Integer.parseInt(st.nextToken()));
			if(idx>=0) sb.append("1\n");
			else sb.append("0\n");
		}
		
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}