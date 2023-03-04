import java.io.*;
import java.util.*;

public class BOJ_3473_교수가된현우 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();
		int num, count;
		for(int i=0;i<N;i++){
			num = Integer.parseInt(in.readLine());
			count = 0;
			for(int n=5;n<=num;n*=5) {
				count+=num/n;
			}
			sb.append(count).append('\n');
		}

		System.out.print(sb);
	}
}
