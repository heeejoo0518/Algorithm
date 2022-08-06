import java.io.*;

public class JO_1309_팩토리얼 {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		long ans = calc(N);
		System.out.print(sb);
		System.out.println(ans);
	}
	private static long calc(long n){
		if(n<1) return 1;
		sb.append(n).append("! = ").append(n);
		if(n>1) sb.append(" * ").append(n-1).append("!");
		sb.append('\n');
		return n*calc(n-1);
	}
}
