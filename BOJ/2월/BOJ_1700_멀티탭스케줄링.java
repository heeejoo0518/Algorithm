import java.io.*;
import java.util.*;

public class BOJ_1700_멀티탭스케줄링 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		int[] order = new int[K];
		PriorityQueue<Integer>[] pqArray = new PriorityQueue[101];
		for (int i = 0; i < K; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			if(pqArray[order[i]] == null) pqArray[order[i]] = new PriorityQueue<>();
			pqArray[order[i]].add(i);
		}

		int answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
			if(pqArray[o1].size()==0 && pqArray[o2].size()==0) return 0;
			else if(pqArray[o1].size()==0) return -1;
			else if(pqArray[o2].size()==0) return 1;
			return pqArray[o2].peek()-pqArray[o1].peek();
		});

		boolean[] state = new boolean[101];
		for(int i=0;i<K;i++){
			if(state[order[i]]) {
				pqArray[order[i]].poll();
				queue.add(queue.poll());//poll해서 순서때문에 다시해줘야함
				continue;
			}
			if(queue.size()>=N){
				state[queue.poll()] = false;
				answer++;
			}
			pqArray[order[i]].poll();
			queue.add(order[i]);//순서 아주 중요
			state[order[i]] = true;
		}

		System.out.println(answer);

	}

}
