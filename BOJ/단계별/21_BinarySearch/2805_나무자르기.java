import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		long m = Long.parseLong(st.nextToken());
		
		long[] trees = new long[n];
		
		st = new StringTokenizer(br.readLine()," ");

		for(int i=0;i<n;i++) {
			trees[i] = Long.parseLong(st.nextToken());
		}
		
		br.close();
		
		
		bw.write(String.valueOf(findHeight(trees, m)));
		bw.flush();
		bw.close();
	}
	public static long findHeight(long[] trees, long m) {
		long low=0;
		long high = Arrays.stream(trees).max().getAsLong();
		long mid, sum;
		
		while(low<=high) {
			mid = (low+high)/2;
			sum = 0;
			
			for(int i=0;i<trees.length;i++) {
				sum += trees[i]>mid? trees[i]-mid:0;
			}
			
			if(sum<m) high = mid-1;
			else low = mid+1;
		}
		
		return low-1;
	}
}