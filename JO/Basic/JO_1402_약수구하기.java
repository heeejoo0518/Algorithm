import java.io.*;
import java.util.*;

public class JO_1402_약수구하기 {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;
		for(int i=1;i<=N;i++){
			if(N%i==0) count++;
			if(count==K){
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
