import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2577_숫자의개수 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long A = Integer.parseInt(in.readLine());
		long B = Integer.parseInt(in.readLine());
		long C = Integer.parseInt(in.readLine());

		int[] result = new int[10];
		
		char[] chars = String.valueOf(A*B*C).toCharArray();
		
		for(char c:chars) {
			result[c-'0']++;
		}
		
		for(int res:result) {
			System.out.println(res);
		}
	}

}
