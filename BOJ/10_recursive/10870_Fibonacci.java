import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] fibonacci = new int[21];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		in.close();
		
		System.out.println(getFibonacci(n));
	}

	public static int getFibonacci(int n) {
		if(n<=1) return n;	//이러면 fibonacci[1]에 저장된 값은 항상 0임. 
							//피보나치 수를 전부 출력하는 게 아니므로 신경x
		if(fibonacci[n]!=0) return fibonacci[n];
		return fibonacci[n] = getFibonacci(n-1)+getFibonacci(n-2);
	}
}

