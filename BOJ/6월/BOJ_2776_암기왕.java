import java.io.*;
import java.util.*;

public class BOJ_2776_암기왕 {
	static int[] number;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		for(int tc=0;tc<T;tc++){
			N = Integer.parseInt(in.readLine());
			number = new int[N];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i=0;i<N;i++) number[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(number);

			int M = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine());
			for(int i=0;i<M;i++){
				if(binarySearch(Integer.parseInt(st.nextToken()))) sb.append("1\n");
				else sb.append("0\n");
				Arrays.binarySearch(number,0);
			}
		}
		System.out.print(sb);
	}

	public static boolean binarySearch(int x){
		int l = 0, h = N-1;
		int m;
		while(l<=h && h < N){
			m = (l+h)/2;

			if(number[m] >= x) h = m-1;
			else l = m+1;
		}

		return l<N && number[l]==x;
	}
}
