import java.io.*;

public class BOJ_2748_피보나치수2 {
	public static void main(String[] args) throws IOException {
		long[] fib = new long[91];
		fib[0] = 0;
		fib[1] = fib[2] = 1;

		for(int i=3;i<91;i++) fib[i] = fib[i-1]+fib[i-2];

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(fib[Integer.parseInt(in.readLine())]);
	}
}
