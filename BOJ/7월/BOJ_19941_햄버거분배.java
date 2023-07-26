import java.io.*;
import java.util.*;

public class BOJ_19941_햄버거분배 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] input = in.readLine().toCharArray();
		int answer = 0;
		for(int i=0;i<N;i++){
			if(input[i]!='P') continue;
			for(int j=Math.max(i-K,0);j<=Math.min(i+K,N-1);j++){
				if(input[j]!='H') continue;
				input[j] = '_';
				answer++;
				break;
			}
		}
		System.out.println(answer);
	}
}
