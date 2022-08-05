import java.io.*;
import java.util.*;

public class JO_1002_최대공약수최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] num = new int[N];
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int g=num[0];
		int l=g;
		for(int i=0;i<N;i++){
			g = gcd(g,num[i]);
			l = lcd(l,num[i]);
		}

		System.out.println(g+" "+l);
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

	private static int lcd(int a, int b){
		return a*b/gcd(a,b);
	}
}
