import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main{
	static long[] lines;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		lines = new long[k];
		for(int i=0;i<k;i++) {
			lines[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		bw.write(String.valueOf(maxLine(n)));
		bw.flush();
		bw.close();
	}
	
	public static long maxLine(int n) {
		long right = Arrays.stream(lines).max().getAsLong();
		long left = 1;
		long mid;
		long sum;
		
		while(left<=right) {
			mid = (right+left)/2;
			sum = 0;
			for(int i=0;i<lines.length;i++) {
				sum += (lines[i]/mid);
			}
			
			if(sum < n) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		
		return left-1;
	}
}