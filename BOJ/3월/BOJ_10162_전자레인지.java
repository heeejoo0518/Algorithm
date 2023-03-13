import java.io.*;
import java.util.*;

public class BOJ_10162_전자레인지 {
	public static void main(String[] args) throws IOException {
		int A = 30;
		int B = 6;

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		if(T%10 != 0){
			System.out.println(-1);
			return;
		}
		T/=10;

		StringBuilder sb = new StringBuilder();
		int[] btn = {30,6};
		for(int b:btn){
			sb.append(T/b).append(' ');
			T%=b;
		}
		System.out.println(sb.append(T));
	}
}
