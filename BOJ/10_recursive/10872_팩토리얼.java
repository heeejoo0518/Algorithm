import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		System.out.println(factorial(N));
		
		in.close();
		
	}
	public static int factorial(int n) {
		if(n<=1) return 1;
		return n*factorial(n-1);
	}
}
