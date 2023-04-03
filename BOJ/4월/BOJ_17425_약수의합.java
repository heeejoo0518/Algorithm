import java.io.*;
import java.util.*;

public class BOJ_17425_약수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int END = 1000001;
		long[] count = new long[END];
		Arrays.fill(count,1);
		for(int i=2;i<END;i++){
			for(int j=i;j<END;j+=i){
				count[j] += i;
			}
			count[i] += count[i-1];
		}

		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++){
			sb.append(count[Integer.parseInt(in.readLine())]).append('\n');
		}

		System.out.print(sb);
	}
}
