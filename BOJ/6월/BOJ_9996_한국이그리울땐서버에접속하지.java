import java.io.*;

public class BOJ_9996_한국이그리울땐서버에접속하지 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		String regex = in.readLine().replace("*",".*");

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			if(in.readLine().matches(regex)) sb.append("DA\n");
			else sb.append("NE\n");
		}

		System.out.print(sb);
	}
}
