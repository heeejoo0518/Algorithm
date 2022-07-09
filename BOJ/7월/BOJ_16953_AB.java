import java.io.*;
import java.util.*;

public class BOJ_16953_AB {
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		Queue<long[]> queue = new ArrayDeque<>();
		queue.offer(new long[]{A,1});

		long[] now;
		while(!queue.isEmpty()){
			now = queue.poll();
			if(now[0]==B){
				System.out.println(now[1]);
				return;
			}
			if(now[0]*2<=B) queue.offer(new long[]{now[0]*2,now[1]+1});
			if(now[0]*10+1<=B) queue.offer(new long[]{now[0]*10+1,now[1]+1});
		}

		System.out.println(-1);
	}

}
