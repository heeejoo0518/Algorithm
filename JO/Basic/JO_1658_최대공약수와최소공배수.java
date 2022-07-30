import java.io.*;
import java.util.*;

public class JO_1658_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int g = gcd(A,B);
		System.out.println(g+"\n"+A/g*B);
	}
	private static int gcd(int a, int b){
		if(a<b){
			int tmp = a;
			a = b;
			b = tmp;
		}

		if(a%b==0) return b;
		return gcd(b,a%b);
	}
}
