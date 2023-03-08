import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_2407_조합 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		BigInteger answer = BigInteger.valueOf(1);
		for(int i=N;i>=N-M+1;i--) answer = answer.multiply(BigInteger.valueOf(i));
		for(int r=M;r>0;r--) answer = answer.divide(BigInteger.valueOf(r));
		System.out.println(answer);

	}
}
