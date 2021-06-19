import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
	
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
	
		br.close();
		
		bw.write(String.valueOf(multiply(a,b,c)));
		bw.flush();
		bw.close();
	}
	
	public static long multiply(int a, int b, int c) {
		if(b<1) return 1;
		if(b==1) return a%c;
		
		long m = multiply(a,b/2,c)%c;

		if(b%2==0) return m*m%c;
		else return (m*m)%c*a%c;
	}
}