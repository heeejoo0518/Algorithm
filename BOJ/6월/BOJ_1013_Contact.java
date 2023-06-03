import java.io.*;

public class BOJ_1013_Contact {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<N;i++){
			if(in.readLine().matches("(100+1+|01)+")) sb.append("YES\n");
			else sb.append("NO\n");
		}

		System.out.print(sb);
	}
}
