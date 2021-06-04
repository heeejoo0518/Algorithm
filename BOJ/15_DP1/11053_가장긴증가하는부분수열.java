import java.io.*;
import java.util.*;

public class Main{
	static int[] sequence;
	static int[] LIS;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		sequence = new int[n+1];
		LIS = new int[n+1]; //첫번째 줄=길이, 두번째 줄=마지막 값
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;st.hasMoreTokens();i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		int max = subsequence(n);

		for(int i=1;i<n;i++) {
			if(max<LIS[i]) max = LIS[i];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(max+"");
		
		bw.flush();
		bw.close();
	}
	
	public static int subsequence(int n) {
		if(n<1) return LIS[0];
		if(LIS[n]!=0) return LIS[n];

		subsequence(n-1);
		
		LIS[n] = 1;
		
		for(int i=1;i<n;i++) {
			int length = LIS[i];
			
			//값이 나보다 작고 길이가 나보다 길거나 같으면
			if(sequence[i]<sequence[n] && length>=LIS[n]) {
				LIS[n] = length+1;
			}
		}
		
		return LIS[n];
	}


}
