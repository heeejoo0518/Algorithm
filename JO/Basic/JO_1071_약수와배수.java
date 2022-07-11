import java.io.*;
import java.util.*;

public class JO_1071_약수와배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(in.readLine());

		int res1 = 0;
		int res2 = 0;

		for(int i=0;i<N;i++){
			if(input[i]%M==0) res1+=input[i];
			if(M%input[i]==0) res2 += input[i];
		}

		System.out.println(res2+"\n"+res1);

	}
}
