import java.io.*;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		int count = 0;
		while(N>0){
			if(N%5==0){
				count += N/5;
				break;
			}
			N-=3;
			count++;
		}

		if(N<0) System.out.println(-1);
		else System.out.println(count);
	}
}
