import java.io.*;
import java.util.*;

public class BOJ_5464_주차장 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] fee = new int[N+1];
		for(int i=1;i<=N;i++) fee[i] = Integer.parseInt(in.readLine());

		int[] weight = new int[M+1];
		for(int i=1;i<=M;i++) weight[i] = Integer.parseInt(in.readLine());

		Queue<Integer> order = new ArrayDeque<>();
		boolean[] status = new boolean[N+1];
		int[] park = new int[M+1];//주차했던 공간 번호
		int empty = N;
		int car, result = 0;

		for(int i=0;i<2*M;i++){
			car = Integer.parseInt(in.readLine());
			if(car>0) {
				order.offer(car);
			}
			else {
				car *= -1;
				status[park[car]] = false;
				empty += 1;
				result += weight[car]*fee[park[car]];
			}

			if(empty > 0 && order.size() > 0){
				empty -= 1;
				for(int j=1;j<=N;j++){
					if(status[j]) continue;
					park[order.poll()] = j;
					status[j] = true;
					break;
				}
			}
		}

		System.out.println(result);
	}
}
