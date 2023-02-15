import java.io.*;
import java.util.*;

public class BOJ_11000_강의실배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->{
			if(o1[0]==o2[0]) return o1[1]-o2[1];
			else return o1[0]-o2[0];
		});
		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(in.readLine());
			queue.offer(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}

		PriorityQueue<Integer> end = new PriorityQueue<>();

		//첫번째 강의
		end.offer(queue.poll()[1]);
		int answer = 1;

		int[] now;
		while(!queue.isEmpty()){
			now = queue.poll();
			if(end.peek()<=now[0]){
				//강의 가능
				end.poll();
				end.offer(now[1]);
			}else{
				//불가능
				end.offer(now[1]);
				answer++;
			}
		}

		System.out.println(answer);
	}

}
