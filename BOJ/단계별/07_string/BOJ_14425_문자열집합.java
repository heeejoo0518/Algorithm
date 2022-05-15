import java.io.*;
import java.util.*;

public class BOJ_14425_문자열집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] S = new String[N];
		for(int i=0;i<N;i++) S[i] = in.readLine();

		Arrays.sort(S);

		int count = 0;
		for(int i=0;i<M;i++){
			if(Arrays.binarySearch(S,in.readLine())>=0) count++;
		}

		System.out.println(count);
	}
}
