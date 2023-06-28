import java.io.*;

public class BOJ_9625_BABBA {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int[] count = {1,0};
		int a,b;
		for(int i=0;i<N;i++){
			a = count[1];
			b = count[0]+count[1];
			count[0] = a;
			count[1] = b;
		}

		System.out.println(count[0]+" "+count[1]);
	}
}
