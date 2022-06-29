import java.io.*;

public class JO_1692_곱셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(in.readLine());
		char[] b = in.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();
		sb.append((b[2]-'0')*a).append('\n');
		sb.append((b[1]-'0')*a).append('\n');
		sb.append((b[0]-'0')*a).append('\n');
		sb.append(Integer.parseInt(String.valueOf(b))*a);
		System.out.println(sb);

	}
}
