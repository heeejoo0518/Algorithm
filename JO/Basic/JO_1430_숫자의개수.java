import java.io.*;

public class JO_1430_숫자의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] result = String.valueOf(Integer.parseInt(in.readLine())*Integer.parseInt(in.readLine())*Integer.parseInt(in.readLine())).toCharArray();

		int[] count = new int[10];
		for(int i=0;i<result.length;i++){
			count[result[i]-'0']++;
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<10;i++) sb.append(count[i]).append('\n');
		System.out.print(sb);
	}
}
