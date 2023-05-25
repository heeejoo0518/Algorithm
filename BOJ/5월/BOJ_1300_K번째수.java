import java.io.*;
import java.util.*;

public class BOJ_1300_K번째수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());

		Queue<Integer> t = new LinkedList<>();
		Queue<Integer> e = new ArrayDeque<>();

		long low = 1, high = N*(long)N+1;
		long mid, cnt;

		while(low<high){
			mid = (low+high)/2;
			cnt=0;
			for(int i=1;i<=N;i++){
				cnt+=Math.min(mid/i,N);
			}
			if(cnt>=K) high = mid;
			else low = mid+1;
		}

		System.out.println(high);
	}
}
