import java.io.*;
import java.util.*;

public class Main{
	static int[] sequence;
	static int[][] LIS;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		sequence = new int[n+1];
		LIS = new int[n+1][2];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;st.hasMoreTokens();i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		subsequence(n);
		
		int max = 0;
		int lastIdx = 0;
		for(int i=1;i<=n;i++) {
			if(max<LIS[i][0]) {
				max = LIS[i][0];
				lastIdx = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(sequence[lastIdx]);
		for(int i=n;i>0;i--) {
			if(LIS[lastIdx][1]==sequence[i]) {
				sb.insert(0, sequence[i]+" ");
				lastIdx = i;
			}
		}
		
		sb.insert(0,max+"\n");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static int[] subsequence(int n) {
		if(n<1) return LIS[0];
		if(LIS[n][0]!=0) return LIS[n];

		subsequence(n-1);
		
		LIS[n][0] = 1;
		
		
		for(int i=1;i<n;i++) {
			int length = LIS[i][0];
			
			//값이 나보다 작고 길이가 나보다 길거나 같으면
			if(sequence[i]<sequence[n] && length>=LIS[n][0]) {
				LIS[n][0] = length+1;
				LIS[n][1] = sequence[i];
			}
		}
		
		return LIS[n];
	}


}
