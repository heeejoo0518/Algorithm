import java.io.*;
import java.util.*;

public class BOJ_1005_ACMCraft2 {
	public static class Building{
		ArrayList<Integer> next = new ArrayList<>();
		int total, enter;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N,K,W;
		int[] time;
		for(int tc=0;tc<T;tc++){
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			time = new int[N+1];
			st = new StringTokenizer(in.readLine());
			for(int i=1;i<=N;i++) time[i] = Integer.parseInt(st.nextToken());

			Building[] buildings = new Building[N+1];
			for(int i=1;i<=N;i++) buildings[i] = new Building();

			//from : 나가는 간선의 목적지 저장(list)
			//to : 들어오는 간선 수 저장
			int from, to;
			for(int i=0;i<K;i++){
				st = new StringTokenizer(in.readLine());
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				buildings[from].next.add(to);
				buildings[to].enter++;
			}

			//찾아야 하는 건물번호
			W = Integer.parseInt(in.readLine());

			//들어오는 간선 0인 걸 큐에 넣기
			Queue<Integer> queue = new ArrayDeque<>();
			for(int i=1;i<=N;i++) {
				if(buildings[i].enter==0) {
					queue.offer(i);
					buildings[i].total = time[i];
					buildings[i].enter = -1;
				}
			}

			int now;
			int answer = 0;
			while(!queue.isEmpty()){
				now = queue.poll();
				if(now==W){
					answer = buildings[now].total;
					break;
				}

				//나가는 간선 리스트 하나씩 탐색
				//n의 total값은 n의 total값과 now의 total값 중 최대값으로 저장
				//enter-1하고, 그 값이 0이라면 n은 더 이상 앞에서 체크해야 하는 간선이 없는 것
				//더이상 체크해야하는 간선이 없다면 큐에 더하고, total에 n번 건물 짓는 시간을 추가함
				//enter을 -1로 바꿔서 방문처리를 대신함
				for(int n:buildings[now].next){
					buildings[n].total = Math.max(buildings[n].total, buildings[now].total);
					buildings[n].enter-=1;
					if(buildings[n].enter==0){
						queue.offer(n);
						buildings[n].total += time[n];
						buildings[n].enter = -1;
					}
				}

			}
			sb.append(answer).append('\n');
		}

		System.out.print(sb);
	}
}
