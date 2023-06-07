import java.io.*;
import java.util.*;

public class BOJ_14490_백대열 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine(),":");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int g = gcd(N,M);

		System.out.println(N/g+":"+M/g);
	}
	public static int gcd(int a, int b){
		if(a<b){
			int tmp = a;
			a = b;
			b = tmp;
		}

		if(b==0) return a;
		return gcd(b,a%b);
	}
}
