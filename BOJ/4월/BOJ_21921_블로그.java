import java.io.*;
import java.util.*;

public class BOJ_21921_블로그 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] count = new int[N];
		st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) count[i] = Integer.parseInt(st.nextToken());

		int tmp = 0;
		for(int i=0;i<X;i++) tmp += count[i];
		int max = tmp;
		int cnt = 1;
		for(int i=X;i<N;i++){
			tmp += count[i]-count[i-X];
			if(max<tmp){
				max = tmp;
				cnt = 1;
			}else if(max==tmp){
				cnt++;
			}
		}

		if(max==0) System.out.println("SAD");
		else System.out.print(max+"\n"+cnt);

	}
}
