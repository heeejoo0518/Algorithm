import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int[] fib = new int[45];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());		
		
		fib[0] = 0; fib[1] = 1;

		StringBuilder sb = new StringBuilder();		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				sb.append("1 0\n");
				continue;
			}
			sb.append(Fibonacci(num-1)+" "+Fibonacci(num)+"\n");
		}
		br.close();
		
		System.out.println(sb);
	}
	
	public static int Fibonacci(int n) {
		if(n<2) return fib[n];
		if(fib[n]==0) fib[n] = Fibonacci(n-1)+Fibonacci(n-2);
		return fib[n];
	}
}