import java.io.*;
import java.util.*;

public class BOJ_3273_두수의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int END = 2000001;
		boolean[] number = new boolean[END];
		for(int i=0;i<N;i++) number[Integer.parseInt(st.nextToken())] = true;
		int X = Integer.parseInt(in.readLine());

		int answer = 0;
		for(int i=1;i<=X>>1;i++){
			if(number[i] && number[X-i] && i != X-i) answer++;
		}
		System.out.println(answer);
	}
}
