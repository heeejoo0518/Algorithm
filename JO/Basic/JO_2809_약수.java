import java.io.*;

public class JO_2809_약수 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++){
			if(N%i==0) sb.append(i).append(' ');
		}

		System.out.println(sb);
	}

}
