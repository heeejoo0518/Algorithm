import java.io.*;

public class BOJ_2292_벌집 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int X = (int)Math.round(Math.pow((N-1)/(double)3,0.5));
		System.out.println(X+1);

		//a(n) = 3n^2 - 3n + 1
		//		x = ((n-1)/3)**(1/2)
		//print(round(x)+1)
	}
}
